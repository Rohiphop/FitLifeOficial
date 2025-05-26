package com.servicios.servicioUsuarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    private String nombre;

    @Email
    @Column(unique = true)
    private String correo;

    @NotBlank
    private String contraseña;

    @NotBlank
    private String rol; // ADMIN, CLIENTE, ENTRENADOR, etc.

    public Usuario() {}
}
