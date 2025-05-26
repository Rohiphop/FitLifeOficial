package main.java.com.servicios.servicioMembresia.repository;

import com.servicios.servicioMembresia.entity.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembresiaRepository extends JpaRepository<Membresia, Long> {
    List<Membresia> findByIdCliente(Long idCliente);
}
