package com.servicios.servicioNotificaciones.service;

import com.servicios.servicioNotificaciones.model.Notificacion;
import com.servicios.servicioNotificaciones.repository.NotificacionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotificacionService {

    private final NotificacionRepository repository;

    public NotificacionService(NotificacionRepository repository) {
        this.repository = repository;
    }

    public List<Notificacion> listarTodas() {
        return repository.findAll();
    }

    public List<Notificacion> listarPorCliente(Long idCliente) {
        return repository.findByIdCliente(idCliente);
    }

    public Optional<Notificacion> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Notificacion enviar(Notificacion notificacion) {
        notificacion.setFechaEnvio(LocalDateTime.now());
        notificacion.setLeida(false);
        return repository.save(notificacion);
    }

    public Notificacion marcarComoLeida(Long id) {
        return repository.findById(id).map(n -> {
            n.setLeida(true);
            return repository.save(n);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
