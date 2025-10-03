package com.example.demo_repositorio.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String Nome;
    String Sobrenome;
    String Clube;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Sobrenome = sobrenome;
    }

    public String getClube() {
        return Clube;
    }

    public void setClube(String clube) {
        Clube = clube;
    }
}
