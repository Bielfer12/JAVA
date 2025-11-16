package com.exercicio.biblioteca.controller;

import com.exercicio.biblioteca.model.Emprestimo;
import com.exercicio.biblioteca.model.Livro;
import com.exercicio.biblioteca.service.BibliotecaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BibliotecaController {

    private final BibliotecaService service;

    public BibliotecaController(BibliotecaService service) {
        this.service = service;
    }

    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return service.listarLivros();
    }

    @GetMapping("/emprestados")
    public List<Emprestimo> getEmprestimos() {
        return service.listarEmprestimos();
    }

    @PostMapping("/emprestados")
    public Object criarEmprestimo(@RequestParam UUID livroId,
                                  @RequestParam String usuarioId) {

        Emprestimo emprestimo = service.criarEmprestimo(livroId, usuarioId);

        if (emprestimo == null) {
            return "Livro não encontrado ou já emprestado.";
        }

        return emprestimo;
    }

    @DeleteMapping("/emprestados/{id}")
    public String devolver(@PathVariable UUID id) {
        boolean ok = service.devolverLivro(id);

        if (!ok)
            return "Empréstimo não encontrado.";

        return "Livro devolvido com sucesso!";
    }
}
