package com.meus_produtos_api.backend.controller;

import com.meus_produtos_api.backend.dto.ProdutosDto;
import com.meus_produtos_api.backend.model.Produtos;
import com.meus_produtos_api.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produtos cadastrarProduto(@RequestBody Produtos produto) {
        return produtoService.cadastrarProduto(produto);
    }

    @GetMapping
    public List<Produtos> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public Produtos buscarProdutoPorId(@PathVariable String id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @GetMapping("/nome/{nome}")
    public List<Produtos> buscarProdutosPorNome(@PathVariable String nome) {
        return produtoService.buscarProdutosPorNome(nome);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produtos atualizarProdutoPorId(@PathVariable String id, @RequestBody Produtos produto) {
        return produtoService.atualizarProdutoPorId(id, produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deletarProdutoPorId(@PathVariable String id) {
        return produtoService.deletarProdutoPorId(id);
    }

    @GetMapping("/userId/{userId}")
    public List<ProdutosDto> buscarProdutosPorUserId(@PathVariable String userId) {
        return produtoService.buscarProdutosPorUserId(userId);
    }
}
