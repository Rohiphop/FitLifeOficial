package com.servicios.servicioSoporte.controller;

import com.servicios.servicioSoporte.model.TicketSoporte;
import com.servicios.servicioSoporte.service.SoporteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/soporte")
public class SoporteController {

    private final SoporteService service;

    public SoporteController(SoporteService service) {
        this.service = service;
    }

    @GetMapping
    public List<TicketSoporte> listar() {
        return service.listar();
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<TicketSoporte> porUsuario(@PathVariable Long idUsuario) {
        return service.porUsuario(idUsuario);
    }

    @GetMapping("/estado/{estado}")
    public List<TicketSoporte> porEstado(@PathVariable String estado) {
        return service.porEstado(estado.toUpperCase());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketSoporte> obtener(@PathVariable Long id) {
        return service.obtener(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TicketSoporte crear(@RequestBody TicketSoporte ticket) {
        return service.crear(ticket);
    }

    @PutMapping("/{id}/resolver")
    public ResponseEntity<TicketSoporte> resolver(@PathVariable Long id, @RequestBody String respuesta) {
        TicketSoporte resuelto = service.actualizarEstadoYRespuesta(id, "RESUELTO", respuesta);
        if (resuelto != null) {
            return ResponseEntity.ok(resuelto);
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
