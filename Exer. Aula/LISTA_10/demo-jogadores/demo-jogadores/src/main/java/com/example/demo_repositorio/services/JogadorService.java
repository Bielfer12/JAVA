package com.example.demo_repositorio.services;

import com.example.demo_repositorio.models.Jogador;
import com.example.demo_repositorio.repositories.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository){
        this.jogadorRepository = jogadorRepository;
    }
    public Jogador CreateJogador(String nome, String sobrenome){
        Jogador novoJogador = new Jogador();
        novoJogador.setNome(nome);
        novoJogador.setSobrenome(sobrenome);
        novoJogador.setClube("Criciuma");
        jogadorRepository.save(novoJogador);
        return novoJogador;
    }

    public List<Jogador> getAllJogadores() {
        jogadorRepository.findAll();
    }

    public Jogador getJogadorById(Long id) {
        return jogadorRepository.findById(id).orElse(null);
    }

    public boolean deleteJogador(Long id) {
        if (jogadorRepository.existsById(id)) {
            jogadorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Jogador> getJogadoresByNome(String nome) {
        return jogadorRepository.findByNomeContainingIgnoreCase(nome);
    }

}
