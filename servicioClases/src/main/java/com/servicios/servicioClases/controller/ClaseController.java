package com.servicios.servicioClases.controller;

import com.servicios.servicioClases.model.Clase;
import com.servicios.servicioClases.service.ClaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
public class ClaseController {

    private final ClaseService service;

    public ClaseController(ClaseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Clase> listar() {
        return service.listar();
    }

    @GetMapping("/proximas")
    public List<Clase> listarProximas() {
        return service.listarProximas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clase> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Clase crear(@RequestBody Clase clase) {
        return service.crear(clase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clase> actualizar(@PathVariable Long id, @RequestBody Clase clase) {
        Clase actualizada = service.actualizar(id, clase);
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
