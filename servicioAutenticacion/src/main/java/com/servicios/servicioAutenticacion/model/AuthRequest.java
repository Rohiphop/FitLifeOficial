package com.servicios.servicioAutenticacion.model;


import lombok.Data;

@Data
public class AuthRequest {
    private String correo;
    private String contrasena;
}
