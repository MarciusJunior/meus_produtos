package com.meus_produtos_api.backend.repository;

import com.meus_produtos_api.backend.model.Usuarios;
import com.meus_produtos_api.backend.service.UsuarioService;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuarios, String> {

    Usuarios findByName(String name);

}
