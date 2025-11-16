package com.example.time;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time")
public class TimeController {

    private final TimeService service;

    public TimeController(TimeService service) {
        this.service = service;
    }

    @GetMapping("/principal")
    public List<Jogador> getTitulares() {
        return service.getTitulares();
    }

    @GetMapping("/reservas")
    public List<Jogador> getReservas() {
        return service.getReservas();
    }

    @PutMapping("/jogador/{posicao}")
    public String substituir(@PathVariable int posicao) {
        Jogador novo = service.substituirJogador(posicao);

        if (novo == null) {
            return "Posição inválida ou sem reservas.";
        }

        return "Jogador substituído por: " + novo.getNome();
    }
}
