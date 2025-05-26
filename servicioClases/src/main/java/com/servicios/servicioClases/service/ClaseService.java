package com.servicios.servicioClases.service;

import com.servicios.servicioClases.model.Clase;
import com.servicios.servicioClases.repository.ClaseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ClaseService {

    private final ClaseRepository repository;

    public ClaseService(ClaseRepository repository) {
        this.repository = repository;
    }

    public List<Clase> listar() {
        return repository.findAll();
    }

    public List<Clase> listarProximas() {
        return repository.findByFechaHoraAfter(LocalDateTime.now());
    }

    public Optional<Clase> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Clase crear(Clase clase) {
        clase.setActiva(true);
        return repository.save(clase);
    }

    public Clase actualizar(Long id, Clase claseNueva) {
        return repository.findById(id).map(c -> {
            c.setNombre(claseNueva.getNombre());
            c.setDescripcion(claseNueva.getDescripcion());
            c.setFechaHora(claseNueva.getFechaHora());
            c.setCupoMaximo(claseNueva.getCupoMaximo());
            c.setEntrenador(claseNueva.getEntrenador());
            c.setActiva(claseNueva.isActiva());
            return repository.save(c);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
