package com.senai.vestiq.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.senai.vestiq.dto.MaterialDTO;
import com.senai.vestiq.entity.Material;
import com.senai.vestiq.repository.MaterialRepository;

import jakarta.validation.Valid;

@Service
public class MaterialService {

    @Autowired
    // injeção de dependencia
    private MaterialRepository repository;

    public MaterialDTO criar(MaterialDTO materialDto) {
        Material material = new Material();
        material.setNome(materialDto.getNome());
        material.setQuantidade(materialDto.getQuantidade());
        material.setTipo(materialDto.getTipo());

        repository.save(material);

        return materialDto;
    }

    public MaterialDTO update(MaterialDTO dto, Long id, @RequestBody @Valid MaterialDTO m) {
        Material material = new Material();
        material.setNome(dto.getNome());
        material.setQuantidade(dto.getQuantidade());
        material.setTipo(dto.getTipo());
        material.setId(id);

        repository.save(material);

        return dto;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<MaterialDTO> listar() {
        List<Material> materiais = repository.findAll();
        List<MaterialDTO> dtos = new ArrayList<>();

        for (Material m : materiais) {
            MaterialDTO dto = new MaterialDTO();
            dto.setNome(dto.getNome());
            dto.setQuantidade(dto.getQuantidade());
            dto.setTipo(dto.getTipo());

            dtos.add(dto);
        }

        return dtos;
    }

	public Material update(Material m, Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}
}
