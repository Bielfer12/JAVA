package com.exercicio.redesocial.service;

import com.exercicio.redesocial.model.Tweet;
import com.exercicio.redesocial.model.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioService() {
        usuarios.add(new Usuario(UUID.randomUUID(), "Gabriel", "gabriel@email.com"));
        usuarios.add(new Usuario(UUID.randomUUID(), "Ana", "ana@email.com"));
        usuarios.add(new Usuario(UUID.randomUUID(), "Carlos", "carlos@email.com"));
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    public Usuario buscarUsuario(UUID id) {
        return usuarios
                .stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Tweet> listarTweets(UUID userId) {
        Usuario user = buscarUsuario(userId);
        if (user == null) return null;
        return user.getTweets();
    }

    public Tweet criarTweet(UUID userId, String mensagem) {
        Usuario user = buscarUsuario(userId);

        if (user == null) return null;

        Tweet tweet = new Tweet(
                UUID.randomUUID(),
                mensagem,
                LocalDateTime.now()
        );

        user.getTweets().add(tweet);
        return tweet;
    }

    public Tweet atualizarTweet(UUID userId, UUID tweetId, String novaMensagem) {
        Usuario user = buscarUsuario(userId);
        if (user == null) return null;

        Optional<Tweet> tweetOpt = user.getTweets()
                .stream()
                .filter(t -> t.getTweetId().equals(tweetId))
                .findFirst();

        if (tweetOpt.isEmpty()) return null;

        Tweet tweet = tweetOpt.get();
        tweet.setMensagem(novaMensagem);
        tweet.setEditado(true);

        return tweet;
    }

    public boolean removerTweet(UUID userId, UUID tweetId) {
        Usuario user = buscarUsuario(userId);
        if (user == null) return false;

        return user.getTweets().removeIf(t -> t.getTweetId().equals(tweetId));
    }
}
