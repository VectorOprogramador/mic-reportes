package com.perfulandia.mic_reportes.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.perfulandia.mic_reportes.model.*;
import com.perfulandia.mic_reportes.service.ReportesService;

@RestController
@RequestMapping("/api/v1/reportes")
public class ReportesController {

    @Autowired
    private ReportesService reportesService;

     @GetMapping
    public ResponseEntity<List<Reportes>> getAllReportes() {
        List<Reportes> reportes = reportesService.findAll();
        return ResponseEntity.ok(reportes);
    }

    // Métodos CRUD existentes...

    @PostMapping("/ventas")
    public ResponseEntity<ReporteVentas> crearReporteVentas(
            @RequestParam Date fechaInicio,
            @RequestParam Date fechaFin) {
        return ResponseEntity.ok(reportesService.crearReporteVentas(fechaInicio, fechaFin));
    }

    @PostMapping("/inventario")
    public ResponseEntity<ReporteInventario> crearReporteInventario(
            @RequestParam Date fechaInicio,
            @RequestParam Date fechaFin) {
        return ResponseEntity.ok(reportesService.crearReporteInventario(fechaInicio, fechaFin));
    }

    @PostMapping("/usuarios-activos")
    public ResponseEntity<ReporteUsuariosActivos> crearReporteUsuariosActivos(
            @RequestParam Date fechaInicio,
            @RequestParam Date fechaFin) {
        return ResponseEntity.ok(reportesService.crearReporteUsuariosActivos(fechaInicio, fechaFin));
    }

    @PostMapping("/{id}/exportar")
    public ResponseEntity<String> exportarReporte(
            @PathVariable Long id,
            @RequestParam String formato) {
        return ResponseEntity.ok(reportesService.exportarReporte(id, formato));
    }
}