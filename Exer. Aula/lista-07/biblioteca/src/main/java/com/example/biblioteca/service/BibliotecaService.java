package com.exercicio.biblioteca.service;

import com.exercicio.biblioteca.model.Emprestimo;
import com.exercicio.biblioteca.model.Livro;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class BibliotecaService {

    private List<Livro> livrosDisponiveis = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public BibliotecaService() {
        livrosDisponiveis.add(new Livro(UUID.randomUUID(), "Dom Casmurro", "Machado de Assis"));
        livrosDisponiveis.add(new Livro(UUID.randomUUID(), "O Hobbit", "Tolkien"));
        livrosDisponiveis.add(new Livro(UUID.randomUUID(), "1984", "George Orwell"));
    }

    public List<Livro> listarLivros() {
        return livrosDisponiveis;
    }

    public List<Emprestimo> listarEmprestimos() {
        return emprestimos;
    }

    public Emprestimo criarEmprestimo(UUID livroId, String usuarioId) {
        Optional<Livro> livroOpt = livrosDisponiveis
                .stream()
                .filter(l -> l.getId().equals(livroId))
                .findFirst();

        if (livroOpt.isEmpty()) {
            return null;
        }

        Livro livro = livroOpt.get();

        Emprestimo emprestimo = new Emprestimo(
                UUID.randomUUID(),
                livro.getId(),
                usuarioId,
                LocalDateTime.now()
        );

        emprestimos.add(emprestimo);

        livrosDisponiveis.remove(livro);

        return emprestimo;
    }

    public boolean devolverLivro(UUID emprestimoId) {
        Optional<Emprestimo> empOpt = emprestimos
                .stream()
                .filter(e -> e.getEmprestimoId().equals(emprestimoId))
                .findFirst();

        if (empOpt.isEmpty()) {
            return false;
        }

        Emprestimo e = empOpt.get();

        livrosDisponiveis.add(
                new Livro(e.getLivroId(), "Título desconhecido", "Autor desconhecido")
        );

        emprestimos.remove(e);

        return true;
    }
}
