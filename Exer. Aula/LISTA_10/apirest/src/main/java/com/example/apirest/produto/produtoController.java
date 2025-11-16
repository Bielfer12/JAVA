package com.exercicio.apirest.produto;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoRepository repo;

    public ProdutoController(ProdutoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Produto> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable UUID id) {
        return repo.findById(id);
    }

    @PostMapping
    public Produto criar(@RequestBody Produto p) {
        return repo.save(p);
    }

    @PatchMapping("/{id}")
    public Produto atualizar(@PathVariable UUID id, @RequestBody Produto dados) {
        Produto p = repo.findById(id);
        if (p != null) {
            if(dados.getNome() != null) p.setNome(dados.getNome());
            if(dados.getPreco() != 0) p.setPreco(dados.getPreco());
        }
        return p;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id) {
        repo.delete(id);
    }
}
