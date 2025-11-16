package com.exercicio.apirest.usuario;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UsuarioRepository {

    private final Map<UUID, Usuario> usuarios = new HashMap<>();

    public List<Usuario> findAll() {
        return new ArrayList<>(usuarios.values());
    }

    public Usuario findById(UUID id) {
        return usuarios.get(id);
    }

    public Usuario save(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    public void delete(UUID id) {
        usuarios.remove(id);
    }
}
