package com.perfulandia.mic_reportes.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.perfulandia.mic_reportes.model.*;
import com.perfulandia.mic_reportes.repository.ReportesRepository;

@Service
public class ReportesService {

    @Autowired
    private ReportesRepository reportesRepository;

    // Métodos CRUD existentes...

     public List<Reportes> findAll() {
        return reportesRepository.findAll(); // Usa el método del JpaRepository
    }

    public ReporteVentas crearReporteVentas(java.util.Date fechaInicio, java.util.Date fechaFin) {
        ReporteVentas reporte = new ReporteVentas();
        reporte.setFechaGeneracion(LocalDateTime.now()); // Usar LocalDateTime.now()
        reporte.setFechaInicio(fechaInicio);
        reporte.setFechaFin(fechaFin);
        reporte.crearReporte();
        return reportesRepository.save(reporte);
    }

    public ReporteInventario crearReporteInventario(java.util.Date fechaInicio, java.util.Date fechaFin) {
        ReporteInventario reporte = new ReporteInventario();
        reporte.setFechaGeneracion(LocalDateTime.now()); // Usar LocalDateTime.now()
        reporte.setFechaInicio(fechaInicio);
        reporte.setFechaFin(fechaFin);
        reporte.crearReporte();
        return reportesRepository.save(reporte);
    }

    public ReporteUsuariosActivos crearReporteUsuariosActivos(java.util.Date fechaInicio, java.util.Date fechaFin) {
        ReporteUsuariosActivos reporte = new ReporteUsuariosActivos();
        reporte.setFechaGeneracion(LocalDateTime.now()); // Usar LocalDateTime.now()
        reporte.setFechaInicio(fechaInicio);
        reporte.setFechaFin(fechaFin);
        reporte.crearReporte();
        return reportesRepository.save(reporte);
    }

    public String exportarReporte(Long id, String formato) {
        Optional<Reportes> reporte = reportesRepository.findById(id);
        if (reporte.isPresent()) {
            reporte.get().exportar(formato);
            return "Reporte exportado en formato " + formato;
        }
        return "Reporte no encontrado";
    }
}