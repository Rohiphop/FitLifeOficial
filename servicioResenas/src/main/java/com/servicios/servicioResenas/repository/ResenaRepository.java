package com.servicios.servicioResenas.repository;

import com.servicios.servicioResenas.model.Resena;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResenaRepository extends JpaRepository<Resena, Long> {
    List<Resena> findByIdClase(Long idClase);
    List<Resena> findByIdEntrenador(Long idEntrenador);
}
