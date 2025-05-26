package com.servicios.servicioResenas.controller;

import com.servicios.servicioResenas.model.Resena;
import com.servicios.servicioResenas.service.ResenaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reseñas")
public class ResenaController {

    private final ResenaService service;

    public ResenaController(ResenaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Resena> listar() {
        return service.listarTodas();
    }

    @GetMapping("/clase/{idClase}")
    public List<Resena> porClase(@PathVariable Long idClase) {
        return service.porClase(idClase);
    }

    @GetMapping("/entrenador/{idEntrenador}")
    public List<Resena> porEntrenador(@PathVariable Long idEntrenador) {
        return service.porEntrenador(idEntrenador);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resena> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Resena crear(@RequestBody Resena reseña) {
        return service.crear(reseña);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resena> actualizar(@PathVariable Long id, @RequestBody Resena reseña) {
        Resena actualizada = service.actualizar(id, reseña);
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
