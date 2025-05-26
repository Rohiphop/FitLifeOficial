package com.servicios.servicioNotificaciones.controller;

import com.servicios.servicioNotificaciones.model.Notificacion;
import com.servicios.servicioNotificaciones.service.NotificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    private final NotificacionService service;

    public NotificacionController(NotificacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Notificacion> listar() {
        return service.listarTodas();
    }

    @GetMapping("/cliente/{idCliente}")
    public List<Notificacion> listarPorCliente(@PathVariable Long idCliente) {
        return service.listarPorCliente(idCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacion> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Notificacion enviar(@RequestBody Notificacion notificacion) {
        return service.enviar(notificacion);
    }

    @PutMapping("/{id}/leida")
    public ResponseEntity<Notificacion> marcarLeida(@PathVariable Long id) {
        Notificacion actualizada = service.marcarComoLeida(id);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
