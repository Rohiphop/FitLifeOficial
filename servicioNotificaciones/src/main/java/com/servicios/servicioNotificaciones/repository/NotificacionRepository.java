package com.servicios.servicioNotificaciones.repository;

import com.servicios.servicioNotificaciones.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    List<Notificacion> findByIdCliente(Long idCliente);
}
