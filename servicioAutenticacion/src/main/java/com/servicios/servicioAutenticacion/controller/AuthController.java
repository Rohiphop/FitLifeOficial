package com.servicios.servicioAutenticacion.controller;

import com.servicios.servicioAutenticacion.service.AuthService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        String token = authService.login(request.getCorreo(), request.getContraseña());
        return token != null ? token : "Credenciales inválidas";
    }

    @Data
    public static class LoginRequest {
        private String correo;
        private String contraseña;
    }
}
