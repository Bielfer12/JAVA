package com.exercicio.cinema.controller;

import com.exercicio.cinema.model.Filme;
import com.exercicio.cinema.model.Ingresso;
import com.exercicio.cinema.service.FilmeService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService service;

    public FilmeController(FilmeService service) {
        this.service = service;
    }

    // CRUD FILMES
    @GetMapping
    public List<Filme> listarFilmes() {
        return service.listarFilmes();
    }

    @PostMapping
    public Filme criarFilme(@RequestBody Filme filme) {
        filme = new Filme(UUID.randomUUID(), filme.getTitulo(), filme.getGenero(), filme.getCapacidade());
        return service.criarFilme(filme);
    }

    @PatchMapping("/{id}")
    public Object atualizarFilme(
            @PathVariable UUID id,
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) Integer capacidade
    ) {
        Filme filme = service.atualizarFilme(id, titulo, genero, capacidade);
        if (filme == null) return "Filme não encontrado.";
        return filme;
    }

    @DeleteMapping("/{id}")
    public String removerFilme(@PathVariable UUID id) {
        boolean ok = service.removerFilme(id);
        return ok ? "Filme removido." : "Filme não encontrado.";
    }

    // INGRESSOS
    @PostMapping("/{id}/ingressos")
    public Object comprarIngresso(@PathVariable UUID id) {
        Ingresso ingresso = service.comprarIngresso(id);

        if (ingresso == null) {
            return "Filme não encontrado ou capacidade esgotada.";
        }

        return ingresso;
    }

    @DeleteMapping("/{filmeId}/ingressos/{ingressoId}")
    public Object devolverIngresso(
            @PathVariable UUID filmeId,
            @PathVariable UUID ingressoId) {

        boolean ok = service.devolverIngresso(filmeId, ingressoId);

        if (!ok) return "Filme ou ingresso não encontrado.";

        return "Ingresso devolvido com sucesso!";
    }
}
