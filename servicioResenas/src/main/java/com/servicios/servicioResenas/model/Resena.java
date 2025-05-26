package com.servicios.servicioResenas.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idCliente;

    private Long idClase; // puede ser null si es una reseña de un entrenador

    private Long idEntrenador; // puede ser null si es una reseña de una clase

    private int puntuacion; // 1 a 5

    private String comentario;

    private LocalDateTime fecha;
}
