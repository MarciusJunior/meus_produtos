package com.meus_produtos_api.backend.service;

import com.meus_produtos_api.backend.dto.ProdutosDto;
import com.meus_produtos_api.backend.model.Produtos;
import com.meus_produtos_api.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public Produtos cadastrarProduto(Produtos produto) {
        produto.setId(UUID.randomUUID().toString().split("-")[0]);
        return produtoRepository.save(produto);
    }

    public List<Produtos> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produtos buscarProdutoPorId(String id) {
        return produtoRepository.findById(id).get();
    }

    public List<Produtos> buscarProdutosPorNome(String name) {
        return produtoRepository.findByName(name);
    }

    public Produtos atualizarProdutoPorId(String id, Produtos produto) {
        Produtos produtoAtualizado = produtoRepository.findById(id).get();
        produtoAtualizado.setName(produto.getName());
        produtoAtualizado.setPrice(produto.getPrice());
        produtoAtualizado.setQuantity(produto.getQuantity());
        produtoAtualizado.setDescription(produto.getDescription());

        return produtoRepository.save(produtoAtualizado);
    }

    public String deletarProdutoPorId(String id) {
        produtoRepository.deleteById(id);

        return "Produto de ID " + id + " deletado com sucesso!";
    }

    public List<ProdutosDto> buscarProdutosPorUserId(String userId) {
        return produtoRepository.findByUserId(userId);
    }

}
