package com.senai.vestiq.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.senai.vestiq.dto.MaterialDTO;
import com.senai.vestiq.entity.Material;
import com.senai.vestiq.repository.MaterialRepository;
import com.senai.vestiq.service.MaterialService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class MaterialController {

    @Autowired 
    //java se lasque.
    private MaterialService service;

    @PostMapping("/material/criar")
    //http://localhost:8080/criar
    public MaterialDTO criar (@RequestBody @Valid MaterialDTO m){
        return service.criar(m);
    }

    @GetMapping("/material/listar")
    public List<MaterialDTO> listar(){
        return service.listar();
    }

    @DeleteMapping("/material/deletar/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);

    }

    @PutMapping("/material/alterar/{id}")
    public Material update(@PathVariable Long id, @RequestBody Material m){
        return service.update(m,id);
    }
}
