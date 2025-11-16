package com.exercicio.apirest.produto;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProdutoRepository {

    private final Map<UUID, Produto> produtos = new HashMap<>();

    public List<Produto> findAll() {
        return new ArrayList<>(produtos.values());
    }

    public Produto findById(UUID id) {
        return produtos.get(id);
    }

    public Produto save(Produto p) {
        produtos.put(p.getId(), p);
        return p;
    }

    public void delete(UUID id) {
        produtos.remove(id);
    }
}
