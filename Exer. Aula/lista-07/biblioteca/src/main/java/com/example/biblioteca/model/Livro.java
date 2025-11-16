package com.exercicio.biblioteca.model;

import java.util.UUID;

public class Livro {

    private UUID id;
    private String titulo;
    private String autor;

    public Livro(UUID id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }
}
