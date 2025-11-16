package com.example.time;

public class Jogador {
    private String nome;
    private String posicao;
    private int idade;

    public Jogador() {}

    public Jogador(String nome, String posicao, int idade) {
        this.nome = nome;
        this.posicao = posicao;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
