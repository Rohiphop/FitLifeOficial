package com.servicios.servicioReportes.service;

import com.servicios.servicioReportes.model.ReportePago;
import com.servicios.servicioReportes.model.ReporteReserva;
import com.servicios.servicioReportes.repository.ReportePagoRepository;
import com.servicios.servicioReportes.repository.ReporteReservaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReporteService {

    private final ReportePagoRepository pagoRepo;
    private final ReporteReservaRepository reservaRepo;

    public ReporteService(ReportePagoRepository pagoRepo, ReporteReservaRepository reservaRepo) {
        this.pagoRepo = pagoRepo;
        this.reservaRepo = reservaRepo;
    }

    public List<ReportePago> pagosEntreFechas(LocalDateTime desde, LocalDateTime hasta) {
        return pagoRepo.findByFechaPagoBetween(desde, hasta);
    }

    public List<ReporteReserva> reservasEntreFechas(LocalDateTime desde, LocalDateTime hasta) {
        return reservaRepo.findByFechaReservaBetween(desde, hasta);
    }
}
