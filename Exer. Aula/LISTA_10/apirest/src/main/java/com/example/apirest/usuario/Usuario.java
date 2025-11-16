package com.exercicio.apirest.usuario;

import java.util.UUID;

public class Usuario {

    private UUID id;
    private String nome;
    private String email;

    public Usuario() {
        this.id = UUID.randomUUID();
    }

    public Usuario(String nome, String email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
    }

    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }

    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
}
