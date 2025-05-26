package com.servicios.servicioInstalaciones.service;

import com.servicios.servicioInstalaciones.model.Instalacion;
import com.servicios.servicioInstalaciones.repository.InstalacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstalacionService {

    private final InstalacionRepository repository;

    public InstalacionService(InstalacionRepository repository) {
        this.repository = repository;
    }

    public List<Instalacion> listar() {
        return repository.findAll();
    }

    public List<Instalacion> disponibles() {
        return repository.findByDisponibleTrue();
    }

    public Optional<Instalacion> obtener(Long id) {
        return repository.findById(id);
    }

    public Instalacion crear(Instalacion i) {
        return repository.save(i);
    }

    public Instalacion actualizar(Long id, Instalacion nueva) {
        return repository.findById(id).map(instalacion -> {
            instalacion.setNombre(nueva.getNombre());
            instalacion.setTipo(nueva.getTipo());
            instalacion.setCapacidadMaxima(nueva.getCapacidadMaxima());
            instalacion.setDisponible(nueva.isDisponible());
            return repository.save(instalacion);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
