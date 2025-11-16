package com.exercicio.redesocial.controller;

import com.exercicio.redesocial.model.Tweet;
import com.exercicio.redesocial.model.Usuario;
import com.exercicio.redesocial.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return service.listarUsuarios();
    }

    @GetMapping("/{id}/tweets")
    public Object listarTweets(@PathVariable UUID id) {
        List<Tweet> tweets = service.listarTweets(id);
        if (tweets == null) return "Usuário não encontrado.";
        return tweets;
    }

    @PostMapping("/{id}/tweets")
    public Object criarTweet(@PathVariable UUID id,
                             @RequestParam String mensagem) {

        Tweet tweet = service.criarTweet(id, mensagem);

        if (tweet == null)
            return "Usuário não encontrado.";

        return tweet;
    }

    @PatchMapping("/{id}/tweets/{tweetId}")
    public Object editarTweet(@PathVariable UUID id,
                              @PathVariable UUID tweetId,
                              @RequestParam String mensagem) {

        Tweet tweet = service.atualizarTweet(id, tweetId, mensagem);

        if (tweet == null)
            return "Usuário ou tweet não encontrado.";

        return tweet;
    }

    @DeleteMapping("/{id}/tweets/{tweetId}")
    public Object removerTweet(@PathVariable UUID id,
                               @PathVariable UUID tweetId) {

        boolean ok = service.removerTweet(id, tweetId);

        if (!ok)
            return "Usuário ou tweet não encontrado.";

        return "Tweet removido com sucesso!";
    }
}
