package com.senai.vestiq.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.senai.vestiq.dto.UsuarioDTO;
import com.senai.vestiq.entity.Usuario;
import com.senai.vestiq.repository.UsuarioRepository;

import jakarta.validation.Valid;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public UsuarioDTO criar(UsuarioDTO usuarioDto){
        Usuario user = new Usuario();
        user.setCargo(usuarioDto.getCargo());
        user.setNome(usuarioDto.getNome());
        user.setEmail(usuarioDto.getEmail());
        user.setSenha(usuarioDto.getSenha());

        repository.save(user);

        return usuarioDto;
    }

    public UsuarioDTO update(UsuarioDTO dto, Long id, @RequestBody @Valid UsuarioDTO u) {
        Usuario user = new Usuario();
        user.setCargo(dto.getCargo());
        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setSenha(dto.getSenha());

        repository.save(user);

        return dto;
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<UsuarioDTO> listar(){
        List<Usuario> usuarios = repository.findAll();
        List<UsuarioDTO> dtos = new ArrayList<>();

        for (Usuario u : usuarios){
            UsuarioDTO dto = new UsuarioDTO();
            dto.setCargo(dto.getCargo());
            dto.setNome(dto.getNome());
            dto.setEmail(dto.getEmail());
            dto.setSenha(dto.getSenha());

            dtos.add(dto);
        }

        return dtos;

    }
}
