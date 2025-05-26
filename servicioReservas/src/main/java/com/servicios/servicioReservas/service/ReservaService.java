package com.servicios.servicioReservas.service;

import com.servicios.servicioReservas.model.Reserva;
import com.servicios.servicioReservas.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository repository;

    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    public List<Reserva> listar() {
        return repository.findAll();
    }

    public List<Reserva> listarPorCliente(Long idCliente) {
        return repository.findByIdCliente(idCliente);
    }

    public Reserva crear(Reserva reserva) {
        reserva.setFechaReserva(LocalDateTime.now());
        reserva.setEstado("ACTIVA");
        return repository.save(reserva);
    }

    public Reserva cancelar(Long id) {
        return repository.findById(id).map(r -> {
            r.setEstado("CANCELADA");
            return repository.save(r);
        }).orElse(null);
    }

    public int contarReservasActivasPorClase(Long idClase) {
        return repository.findByIdClaseAndEstado(idClase, "ACTIVA").size();
    }

    public Optional<Reserva> obtenerPorId(Long id) {
        return repository.findById(id);
    }
}
