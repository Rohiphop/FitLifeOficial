package com.servicios.servicioAutenticacion.controller;


import com.servicios.servicioAutenticacion.model.AuthRequest;
import com.servicios.servicioAutenticacion.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        String respuesta = service.autenticar(request);
        return ResponseEntity.ok(respuesta);
    }
}
