package com.servicios.servicioReservas.repository;

import com.servicios.servicioReservas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByIdCliente(Long idCliente);
    List<Reserva> findByIdClaseAndEstado(Long idClase, String estado);
}
