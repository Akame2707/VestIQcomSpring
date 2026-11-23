package com.senai.vestiq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.senai.vestiq.entity.Usuario;
import com.senai.vestiq.repository.UsuarioRepository;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository r;

    // Criar usuário
    @PostMapping("/usuario/criar")
    public Usuario criar(@RequestBody Usuario u) {
        return r.save(u);
    }

    // Listar usuários
    @GetMapping("/usuario/listar")
    public List<Usuario> listar() {
        return r.findAll();
    }

    // Deletar usuário
    @DeleteMapping("/usuario/deletar/{id}")
    public void delete(@PathVariable Long id) {
        r.deleteById(id);
    }

    // Alterar usuário
    @PutMapping("/usuario/alterar/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario u) {
        u.setId(id);
        return r.save(u);
    }
}