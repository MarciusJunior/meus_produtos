package com.meus_produtos_api.backend.service;

import com.meus_produtos_api.backend.model.Usuarios;
import com.meus_produtos_api.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuarios cadastrarUsuario(Usuarios usuario) {
        usuario.setId(UUID.randomUUID().toString().split("-")[0]);
        String senhaCriptografada = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
        usuario.setPassword(senhaCriptografada);

        return usuarioRepository.save(usuario);
    }

    public List<Usuarios> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuarios buscarUsuarioPorId(String id) {
        return usuarioRepository.findById(id).get();
    }

    public Usuarios atualizarUsuarioPorId(String id, Usuarios usuario){
        Usuarios usuarioAtualizado = usuarioRepository.findById(id).get();
        usuarioAtualizado.setName(usuario.getName());
        usuarioAtualizado.setEmail(usuario.getEmail());

        return usuarioRepository.save(usuarioAtualizado);
    }

    public String deletarUsuarioPorId(String id) {
        usuarioRepository.deleteById(id);

        return "Usuario de ID " + id + " deletado com sucesso!";
    }
}
