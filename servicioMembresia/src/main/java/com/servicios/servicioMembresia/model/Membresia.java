package main.java.com.servicios.servicioMembresia.model;



import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Membresia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idCliente; // ID del usuario asociado

    private String tipo; // Mensual, Anual, Premium, etc.

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private String estado; // ACTIVA, EXPIRADA, CANCELADA
}
