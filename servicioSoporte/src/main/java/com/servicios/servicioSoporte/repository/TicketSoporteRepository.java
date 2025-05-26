package com.servicios.servicioSoporte.repository;

import com.servicios.servicioSoporte.model.TicketSoporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketSoporteRepository extends JpaRepository<TicketSoporte, Long> {
    List<TicketSoporte> findByIdUsuario(Long idUsuario);
    List<TicketSoporte> findByEstado(String estado);
}
