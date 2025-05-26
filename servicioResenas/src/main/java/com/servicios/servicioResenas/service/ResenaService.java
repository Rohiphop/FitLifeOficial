package com.servicios.servicioResenas.service;

import com.servicios.servicioResenas.model.Resena;
import com.servicios.servicioResenas.repository.ResenaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ResenaService {

    private final ResenaRepository repository;

    public ResenaService(ResenaRepository repository) {
        this.repository = repository;
    }

    public List<Resena> listarTodas() {
        return repository.findAll();
    }

    public List<Resena> porClase(Long idClase) {
        return repository.findByIdClase(idClase);
    }

    public List<Resena> porEntrenador(Long idEntrenador) {
        return repository.findByIdEntrenador(idEntrenador);
    }

    public Optional<Resena> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Resena crear(Resena reseña) {
        reseña.setFecha(LocalDateTime.now());
        return repository.save(reseña);
    }

    public Resena actualizar(Long id, Resena nueva) {
        return repository.findById(id).map(r -> {
            r.setComentario(nueva.getComentario());
            r.setPuntuacion(nueva.getPuntuacion());
            return repository.save(r);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
