package com.example.demo_repositorio.repositories;

import com.example.demo_repositorio.models.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JogadorRepository extends JpaRepository<Jogador, UUID> {
    List<Jogador> findByNomeContainingIgnoreCase(String nome);
}
