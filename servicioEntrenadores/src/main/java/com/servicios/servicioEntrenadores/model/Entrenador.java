package com.servicios.servicioEntrenadores.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String correo;

    private String especialidad; // Ej: Spinning, Yoga, Funcional

    private String disponibilidad; // Ej: Lunes a Viernes 8:00 - 14:00

    private boolean activo;
}
