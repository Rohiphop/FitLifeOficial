package com.servicios.servicioNotificaciones.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idCliente;

    private String tipo; // CORREO, APP, SMS

    private String mensaje;

    private boolean leida;

    private LocalDateTime fechaEnvio;
}
