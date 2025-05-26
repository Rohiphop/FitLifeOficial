package com.servicios.servicioInstalaciones.controller;

import com.servicios.servicioInstalaciones.model.Instalacion;
import com.servicios.servicioInstalaciones.service.InstalacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instalaciones")
public class InstalacionController {

    private final InstalacionService service;

    public InstalacionController(InstalacionService service) {
        this.service = service;
    }

    @GetMapping
    public List<Instalacion> listar() {
        return service.listar();
    }

    @GetMapping("/disponibles")
    public List<Instalacion> disponibles() {
        return service.disponibles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instalacion> obtener(@PathVariable Long id) {
        return service.obtener(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Instalacion crear(@RequestBody Instalacion i) {
        return service.crear(i);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instalacion> actualizar(@PathVariable Long id, @RequestBody Instalacion i) {
        Instalacion actualizada = service.actualizar(id, i);
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
