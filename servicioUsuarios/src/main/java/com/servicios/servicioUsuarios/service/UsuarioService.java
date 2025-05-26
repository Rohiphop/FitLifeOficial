package com.fitlife.usuarios.service;

import com.fitlife.usuarios.model.Usuario;
import com.fitlife.usuarios.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Usuario crear(Usuario usuario) {
        return repository.save(usuario);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public Usuario actualizar(Long id, Usuario usuarioActualizado) {
        return repository.findById(id).map(usuario -> {
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            usuario.setContrasena(usuarioActualizado.getContrasena());
            usuario.setRol(usuarioActualizado.getRol());
            usuario.setActivo(usuarioActualizado.isActivo());
            return repository.save(usuario);
        }).orElse(null);
    }
}
