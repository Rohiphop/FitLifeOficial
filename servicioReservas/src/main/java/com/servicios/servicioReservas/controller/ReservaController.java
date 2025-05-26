package com.servicios.servicioReservas.controller;

import com.servicios.servicioReservas.model.Reserva;
import com.servicios.servicioReservas.service.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reserva> listar() {
        return service.listar();
    }

    @GetMapping("/cliente/{idCliente}")
    public List<Reserva> listarPorCliente(@PathVariable Long idCliente) {
        return service.listarPorCliente(idCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/clase/{idClase}/cupos")
    public int contarCuposUsados(@PathVariable Long idClase) {
        return service.contarReservasActivasPorClase(idClase);
    }

    @PostMapping
    public Reserva crear(@RequestBody Reserva reserva) {
        return service.crear(reserva);
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Reserva> cancelar(@PathVariable Long id) {
        Reserva cancelada = service.cancelar(id);
        if (cancelada != null) {
            return ResponseEntity.ok(cancelada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
