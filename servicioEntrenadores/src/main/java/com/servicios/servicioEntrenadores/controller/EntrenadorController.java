package com.servicios.servicioEntrenadores.controller;

import com.servicios.servicioEntrenadores.model.Entrenador;
import com.servicios.servicioEntrenadores.service.EntrenadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
public class EntrenadorController {

    private final EntrenadorService service;

    public EntrenadorController(EntrenadorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Entrenador> listar() {
        return service.listar();
    }

    @GetMapping("/activos")
    public List<Entrenador> listarActivos() {
        return service.listarActivos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrenador> obtener(@PathVariable Long id) {
        return service.obtener(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Entrenador crear(@RequestBody Entrenador entrenador) {
        return service.crear(entrenador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrenador> actualizar(@PathVariable Long id, @RequestBody Entrenador entrenador) {
        Entrenador actualizado = service.actualizar(id, entrenador);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
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
