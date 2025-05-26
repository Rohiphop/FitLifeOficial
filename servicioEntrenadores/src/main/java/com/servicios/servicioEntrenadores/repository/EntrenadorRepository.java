package com.servicios.servicioEntrenadores.repository;

import com.servicios.servicioEntrenadores.model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
    List<Entrenador> findByActivo(boolean activo);
}
