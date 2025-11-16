package com.exercicio.apirest.usuario;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repo;

    public UsuarioController(UsuarioRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Usuario> listar() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable UUID id) {
        return repo.findById(id);
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return repo.save(usuario);
    }

    @PatchMapping("/{id}")
    public Usuario atualizar(@PathVariable UUID id, @RequestBody Usuario dados) {
        Usuario u = repo.findById(id);
        if (u != null) {
            if (dados.getNome() != null) u.setNome(dados.getNome());
            if (dados.getEmail() != null) u.setEmail(dados.getEmail());
        }
        return u;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id) {
        repo.delete(id);
    }
}
