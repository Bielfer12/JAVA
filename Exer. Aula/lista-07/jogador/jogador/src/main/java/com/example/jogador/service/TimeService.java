package com.example.time;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeService {

    private final List<Jogador> jogadores = new ArrayList<>();

    public TimeService() {
        // Inicializa titulares (0 a 10)
        for (int i = 0; i < 11; i++) {
            jogadores.add(new Jogador("Titular " + i, "Posição " + i, 20 + i));
        }

        // Inicializa reservas (11 a 15)
        for (int i = 11; i < 16; i++) {
            jogadores.add(new Jogador("Reserva " + i, "Posição " + i, 20 + i));
        }
    }

    public List<Jogador> getTitulares() {
        return jogadores.subList(0, 11);
    }

    public List<Jogador> getReservas() {
        return jogadores.subList(11, jogadores.size());
    }

    public Jogador substituirJogador(int posicaoTitular) {

        if (posicaoTitular < 0 || posicaoTitular >= 11) {
            return null; // posição inválida
        }

        if (getReservas().isEmpty()) {
            return null;
        }

        // pega o primeiro reserva
        Jogador reserva = getReservas().get(0);

        // troca
        Jogador titularSai = jogadores.set(posicaoTitular, reserva);

        // remove reserva da posição antiga
        jogadores.remove(reserva);

        // adiciona o titular que saiu como reserva
        jogadores.add(titularSai);

        return reserva;
    }
}
