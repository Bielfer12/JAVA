package com.exercicio.cinema.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Filme {

    private UUID id;
    private String titulo;
    private String genero;
    private int capacidade;
    private int assentosOcupados;
    private List<Ingresso> ingressos = new ArrayList<>();

    public Filme(UUID id, String titulo, String genero, int capacidade) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.capacidade = capacidade;
        this.assentosOcupados = 0;
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getAssentosOcupados() {
        return assentosOcupados;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void ocuparAssento() {
        this.assentosOcupados++;
    }

    public void liberarAssento() {
        this.assentosOcupados--;
    }
}
