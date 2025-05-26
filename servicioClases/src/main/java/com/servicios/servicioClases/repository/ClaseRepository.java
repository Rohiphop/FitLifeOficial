package com.servicios.servicioClases.repository;

import com.servicios.servicioClases.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ClaseRepository extends JpaRepository<Clase, Long> {
    List<Clase> findByFechaHoraAfter(LocalDateTime fecha); // Buscar clases futuras
}
