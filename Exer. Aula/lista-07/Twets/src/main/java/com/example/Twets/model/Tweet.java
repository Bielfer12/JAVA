package com.exercicio.redesocial.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Tweet {

    private UUID tweetId;
    private String mensagem;
    private boolean editado;
    private LocalDateTime dataCriacao;

    public Tweet(UUID tweetId, String mensagem, LocalDateTime dataCriacao) {
        this.tweetId = tweetId;
        this.mensagem = mensagem;
        this.editado = false;
        this.dataCriacao = dataCriacao;
    }

    public UUID getTweetId() {
        return tweetId;
    }

    public String getMensagem() {
        return mensagem;
    }

    public boolean isEditado() {
        return editado;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public void setEditado(boolean editado) {
        this.editado = editado;
    }
}
