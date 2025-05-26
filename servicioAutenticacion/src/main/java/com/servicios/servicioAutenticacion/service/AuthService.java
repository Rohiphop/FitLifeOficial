package com.servicios.servicioAutenticacion.service;


import com.servicios.servicioAutenticacion.model.Usuario;
import com.servicios.servicioAutenticacion.repository.UsuarioRepository;
import com.servicios.servicioAutenticacion.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(String correo, String contraseña) {
        Optional<Usuario> user = repo.findByCorreo(correo);
        if (user.isPresent() && user.get().getContraseña().equals(contraseña)) {
            return jwtUtil.generateToken(correo);
        }
        return null;
    }
}
