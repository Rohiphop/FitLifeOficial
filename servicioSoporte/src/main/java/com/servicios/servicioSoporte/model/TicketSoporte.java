package com.servicios.servicioSoporte.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketSoporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idUsuario;

    private String categoria; // Ej: "Plataforma", "Pago", "Cuenta"

    private String descripcion;

    private String estado; // "PENDIENTE", "EN_PROCESO", "RESUELTO"

    private LocalDateTime fechaCreacion;

    private String respuesta;
}
