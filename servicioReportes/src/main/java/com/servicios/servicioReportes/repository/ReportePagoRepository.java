package com.servicios.servicioReportes.repository;

import com.servicios.servicioReportes.model.ReportePago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportePagoRepository extends JpaRepository<ReportePago, Long> {
    List<ReportePago> findByFechaPagoBetween(LocalDateTime desde, LocalDateTime hasta);
}
