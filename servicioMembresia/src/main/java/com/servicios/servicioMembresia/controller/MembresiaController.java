package main.java.com.servicios.servicioMembresia.controller;

import com.servicios.servicioMembresia.entity.Membresia;
import com.servicios.servicioMembresia.service.MembresiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membresias")
public class MembresiaController {

    private final MembresiaService service;

    public MembresiaController(MembresiaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Membresia> listar() {
        return service.listarTodas();
    }

    @GetMapping("/cliente/{idCliente}")
    public List<Membresia> listarPorCliente(@PathVariable Long idCliente) {
        return service.listarPorCliente(idCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membresia> obtener(@PathVariable Long id) {
        return service.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Membresia crear(@RequestBody Membresia membresia) {
        return service.crear(membresia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Membresia> actualizar(@PathVariable Long id, @RequestBody Membresia membresia) {
        Membresia actualizada = service.actualizar(id, membresia);
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
