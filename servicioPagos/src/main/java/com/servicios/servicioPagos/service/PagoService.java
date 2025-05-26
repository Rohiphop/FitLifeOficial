package com.servicios.servicioPagos.service;

import com.servicios.servicioPagos.model.Pago;
import com.servicios.servicioPagos.repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    private final PagoRepository repository;

    public PagoService(PagoRepository repository) {
        this.repository = repository;
    }

    public List<Pago> listarTodos() {
        return repository.findAll();
    }

    public List<Pago> listarPorCliente(Long idCliente) {
        return repository.findByIdCliente(idCliente);
    }

    public Optional<Pago> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Pago registrar(Pago pago) {
        pago.setFechaPago(LocalDateTime.now());
        pago.setEstado("COMPLETADO");
        return repository.save(pago);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
