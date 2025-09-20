package com.exemplo.timefutebol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class JogadorController {

    @Autowired
    private TimeService timeService;

    // GET /principal - lista titulares
    @GetMapping("/principal")
    public List<Jogador> listarTitulares() {
        return timeService.getTitulares();
    }

    // GET /reservas - lista reservas
    @GetMapping("/reservas")
    public List<Jogador> listarReservas() {
        return timeService.getReservas();
    }

    // PUT /jogador/{posicao} - substitui jogador
    @PutMapping("/jogador/{posicao}")
    public String substituirJogador(
            @PathVariable int posicao,
            @RequestBody Map<String, String> body) {

        String nomeReserva = body.get("nomeReserva");
        return timeService.substituirJogador(posicao, nomeReserva);
    }
}
