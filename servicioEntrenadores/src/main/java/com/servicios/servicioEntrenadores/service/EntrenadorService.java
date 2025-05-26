package com.servicios.servicioEntrenadores.service;

import com.servicios.servicioEntrenadores.model.Entrenador;
import com.servicios.servicioEntrenadores.repository.EntrenadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {

    private final EntrenadorRepository repository;

    public EntrenadorService(EntrenadorRepository repository) {
        this.repository = repository;
    }

    public List<Entrenador> listar() {
        return repository.findAll();
    }

    public List<Entrenador> listarActivos() {
        return repository.findByActivo(true);
    }

    public Optional<Entrenador> obtener(Long id) {
        return repository.findById(id);
    }

    public Entrenador crear(Entrenador entrenador) {
        entrenador.setActivo(true);
        return repository.save(entrenador);
    }

    public Entrenador actualizar(Long id, Entrenador nuevo) {
        return repository.findById(id).map(e -> {
            e.setNombre(nuevo.getNombre());
            e.setCorreo(nuevo.getCorreo());
            e.setEspecialidad(nuevo.getEspecialidad());
            e.setDisponibilidad(nuevo.getDisponibilidad());
            e.setActivo(nuevo.isActivo());
            return repository.save(e);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
