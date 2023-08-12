package com.meus_produtos_api.backend.repository;

import com.meus_produtos_api.backend.dto.ProdutosDto;
import com.meus_produtos_api.backend.model.Produtos;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProdutoRepository extends MongoRepository<Produtos, String> {

    List<Produtos> findByName(String name);

    List<ProdutosDto> findByUserId(String userId);
}
