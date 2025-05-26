package com.servicios.servicioSoporte.service;

import com.servicios.servicioSoporte.model.TicketSoporte;
import com.servicios.servicioSoporte.repository.TicketSoporteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SoporteService {

    private final TicketSoporteRepository repository;

    public SoporteService(TicketSoporteRepository repository) {
        this.repository = repository;
    }

    public List<TicketSoporte> listar() {
        return repository.findAll();
    }

    public List<TicketSoporte> porUsuario(Long idUsuario) {
        return repository.findByIdUsuario(idUsuario);
    }

    public List<TicketSoporte> porEstado(String estado) {
        return repository.findByEstado(estado);
    }

    public Optional<TicketSoporte> obtener(Long id) {
        return repository.findById(id);
    }

    public TicketSoporte crear(TicketSoporte ticket) {
        ticket.setFechaCreacion(LocalDateTime.now());
        ticket.setEstado("PENDIENTE");
        return repository.save(ticket);
    }

    public TicketSoporte actualizarEstadoYRespuesta(Long id, String nuevoEstado, String respuesta) {
        return repository.findById(id).map(t -> {
            t.setEstado(nuevoEstado);
            t.setRespuesta(respuesta);
            return repository.save(t);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
