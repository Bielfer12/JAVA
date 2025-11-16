package com.exercicio.cinema.service;

import com.exercicio.cinema.model.Filme;
import com.exercicio.cinema.model.Ingresso;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FilmeService {

    private List<Filme> filmes = new ArrayList<>();

    public FilmeService() {
        filmes.add(new Filme(UUID.randomUUID(), "Interestelar", "Ficção", 100));
        filmes.add(new Filme(UUID.randomUUID(), "O Senhor dos Anéis", "Fantasia", 180));
    }

    // CRUD FILMES
    public List<Filme> listarFilmes() {
        return filmes;
    }

    public Filme criarFilme(Filme filme) {
        filmes.add(filme);
        return filme;
    }

    public Filme buscarFilme(UUID id) {
        return filmes.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean removerFilme(UUID id) {
        return filmes.removeIf(f -> f.getId().equals(id));
    }

    public Filme atualizarFilme(UUID id, String titulo, String genero, Integer capacidade) {
        Filme filme = buscarFilme(id);
        if (filme == null) return null;

        if (titulo != null) filme.setTitulo(titulo);
        if (genero != null) filme.setGenero(genero);
        if (capacidade != null) filme.setCapacidade(capacidade);

        return filme;
    }

    // INGRESSOS
    public Ingresso comprarIngresso(UUID filmeId) {
        Filme filme = buscarFilme(filmeId);
        if (filme == null) return null;

        if (filme.getAssentosOcupados() >= filme.getCapacidade()) {
            return null; // sem assentos
        }

        int assento = filme.getAssentosOcupados() + 1;

        Ingresso ingresso = new Ingresso(UUID.randomUUID(), filmeId, assento);

        filme.getIngressos().add(ingresso);
        filme.ocuparAssento();

        return ingresso;
    }

    public boolean devolverIngresso(UUID filmeId, UUID ingressoId) {
        Filme filme = buscarFilme(filmeId);
        if (filme == null) return false;

        Optional<Ingresso> ingressoOpt = filme.getIngressos().stream()
                .filter(i -> i.getIngressoId().equals(ingressoId))
                .findFirst();

        if (ingressoOpt.isEmpty()) return false;

        filme.getIngressos().remove(ingressoOpt.get());
        filme.liberarAssento();

        return true;
    }
}
