package com.example.timefutebol;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeService {
    private final List<Jogador> jogadores = new ArrayList<>();

    public TimeService() {
        inicializarTime();
    }

    // Inicializa o time com 11 titulares e 5 reservas
    private void inicializarTime() {
        // Titulares
        jogadores.add(new Jogador("João", "Goleiro", 29));
        jogadores.add(new Jogador("Pedro", "Lateral Direito", 25));
        jogadores.add(new Jogador("Lucas", "Zagueiro", 28));
        jogadores.add(new Jogador("Matheus", "Zagueiro", 27));
        jogadores.add(new Jogador("Carlos", "Lateral Esquerdo", 26));
        jogadores.add(new Jogador("Rafael", "Volante", 24));
        jogadores.add(new Jogador("André", "Volante", 25));
        jogadores.add(new Jogador("Gabriel", "Meia", 23));
        jogadores.add(new Jogador("Felipe", "Meia", 24));
        jogadores.add(new Jogador("Bruno", "Atacante", 27));
        jogadores.add(new Jogador("Diego", "Atacante", 26));

        // Reservas
        jogadores.add(new Jogador("Thiago", "Meia", 23));
        jogadores.add(new Jogador("Henrique", "Atacante", 22));
        jogadores.add(new Jogador("Marcos", "Volante", 21));
        jogadores.add(new Jogador("Victor", "Zagueiro", 25));
        jogadores.add(new Jogador("Eduardo", "Lateral", 24));
    }

    // Retorna lista de titulares
    public List<Jogador> getTitulares() {
        return jogadores.subList(0, 11);
    }

    // Retorna lista de reservas
    public List<Jogador> getReservas() {
        return jogadores.subList(11, jogadores.size());
    }

    // Substitui um titular por um reserva
    public String substituirJogador(int posicaoTitular, String nomeReserva) {
        if (posicaoTitular < 0 || posicaoTitular > 10) {
            return "Posição inválida! Use valores de 0 a 10.";
        }

        // Encontrar índice do reserva pelo nome
        int indexReserva = -1;
        for (int i = 11; i < jogadores.size(); i++) {
            if (jogadores.get(i).getNome().equalsIgnoreCase(nomeReserva)) {
                indexReserva = i;
                break;
            }
        }

        if (indexReserva == -1) {
            return "Reserva não encontrado ou já foi usado.";
        }

        Jogador titular = jogadores.get(posicaoTitular);
        Jogador reserva = jogadores.get(indexReserva);

        // Troca os jogadores
        jogadores.set(posicaoTitular, reserva);
        jogadores.set(indexReserva, titular);

        return String.format("Substituição realizada: %s saiu, %s entrou.",
                titular.getNome(), reserva.getNome());
    }
}
