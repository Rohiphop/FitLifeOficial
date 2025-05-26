package com.servicios.servicioPagos.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idCliente;

    private Double monto;

    private String metodoPago; // Ej: Tarjeta, Transferencia, Efectivo

    private String descripcion; // Ej: Membresía mensual, clase personalizada, etc.

    private LocalDateTime fechaPago;

    private String estado; // COMPLETADO, PENDIENTE, FALLIDO
}
