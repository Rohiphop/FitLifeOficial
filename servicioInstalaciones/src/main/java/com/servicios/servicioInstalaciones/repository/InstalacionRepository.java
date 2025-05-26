package com.servicios.servicioInstalaciones.repository;

import com.servicios.servicioInstalaciones.model.Instalacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstalacionRepository extends JpaRepository<Instalacion, Long> {
    List<Instalacion> findByDisponibleTrue();
}
