package main.java.com.servicios.servicioMembresia.service;

import com.servicios.servicioMembresia.entity.Membresia;
import com.servicios.servicioMembresia.repository.MembresiaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembresiaService {

    private final MembresiaRepository repository;

    public MembresiaService(MembresiaRepository repository) {
        this.repository = repository;
    }

    public List<Membresia> listarTodas() {
        return repository.findAll();
    }

    public List<Membresia> listarPorCliente(Long idCliente) {
        return repository.findByIdCliente(idCliente);
    }

    public Optional<Membresia> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Membresia crear(Membresia membresia) {
        return repository.save(membresia);
    }

    public Membresia actualizar(Long id, Membresia actualizada) {
        return repository.findById(id).map(m -> {
            m.setTipo(actualizada.getTipo());
            m.setFechaInicio(actualizada.getFechaInicio());
            m.setFechaFin(actualizada.getFechaFin());
            m.setEstado(actualizada.getEstado());
            return repository.save(m);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
