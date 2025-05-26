package com.servicios.servicioInstalaciones.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instalacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String tipo; // Ej: Sala de Spinning, Zona Cardio, Sala Multiuso

    private int capacidadMaxima;

    private boolean disponible;
}
