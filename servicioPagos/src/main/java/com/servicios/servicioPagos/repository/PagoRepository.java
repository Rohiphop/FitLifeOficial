package com.servicios.servicioPagos.repository;

import com.servicios.servicioPagos.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByIdCliente(Long idCliente);
}
