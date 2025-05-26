package com.servicios.servicioAutenticacion.service;



import com.servicios.servicioAutenticacion.model.AuthRequest;
import com.servicios.servicioAutenticacion.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository repository;

    public AuthService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public String autenticar(AuthRequest request) {
        return repository.findByCorreo(request.getCorreo())
                .filter(user -> user.getContrasena().equals(request.getContrasena()))
                .map(user -> "TOKEN_" + user.getId()) // Simulación de token
                .orElse("Credenciales incorrectas");
    }
}
