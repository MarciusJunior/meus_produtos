package com.meus_produtos_api.backend.controller;

import com.meus_produtos_api.backend.model.Usuarios;
import com.meus_produtos_api.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios cadastrarUsuario(@RequestBody Usuarios usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }

    @GetMapping
    public List<Usuarios> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuarios buscarUsuarioPorId(@PathVariable String id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    @PutMapping("/{id}")
    public Usuarios atualizarUsuarioPorId(@PathVariable String id, @RequestBody Usuarios usuario){
        return usuarioService.atualizarUsuarioPorId(id, usuario);
    }

    @DeleteMapping("/{id}")
    public String deletarUsuarioPorId(@PathVariable String id) {
        return usuarioService.deletarUsuarioPorId(id);
    }

}
