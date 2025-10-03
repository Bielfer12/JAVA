package com.example.demo_repositorio.controllers;

import com.example.demo_repositorio.models.Jogador;
import com.example.demo_repositorio.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    @Autowired
    private JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService){
        this.jogadorService = jogadorService;
    }
    @PostMapping
    public Jogador createJogador(@RequestBody Jogador jogador){
        return jogadorService.CreateJogador(jogador.getNome(), jogador.getSobrenome());
    }
    @GetMapping
    public List<Jogador> getAllJogadores(){
        return jogadorService.getAllJogadores();
    }

}
