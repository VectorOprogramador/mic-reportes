package com.perfulandia.mic_reportes.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.perfulandia.mic_reportes.model.Reportes;
import com.perfulandia.mic_reportes.service.ReportesService;

@RestController
@RequestMapping("/api/v1/reportes")
public class ReportesController {

    @Autowired
    private ReportesService reportesService;

    @GetMapping
    public ResponseEntity<List<Reportes>> getReportes() {
        List<Reportes> reportes = reportesService.findAll();
        if (!reportes.isEmpty()) {
            return new ResponseEntity<>(reportes, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reportes> getReportesById(@PathVariable Long id) {
        if (reportesService.existsById(id)) {
            return new ResponseEntity<>(reportesService.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

        // Métodos adicionales:
    @PostMapping
    public ResponseEntity<Reportes> createReporte(@RequestBody Reportes reporte) {
        return new ResponseEntity<>(reportesService.save(reporte), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReporte(@PathVariable Long id) {
        reportesService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reportes> updateResena(
        @PathVariable Long id,
        @RequestBody Reportes reporteDetails
    ) {
        return reportesService.findById(id)
            .map(reporteExistente -> {
                // Actualizar campos necesarios
                reporteExistente.setMensajereporte(reporteDetails.getMensajereporte());
                // Agrega más campos si tu entidad los tiene
                
                Reportes reporteActualizado = reportesService.save(reporteExistente);
                return new ResponseEntity<>(reporteActualizado, HttpStatus.OK);
            })
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}