package com.servicios.servicioReportes.repository;

import com.servicios.servicioReportes.model.ReporteReserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReporteReservaRepository extends JpaRepository<ReporteReserva, Long> {
    List<ReporteReserva> findByFechaReservaBetween(LocalDateTime desde, LocalDateTime hasta);
}
