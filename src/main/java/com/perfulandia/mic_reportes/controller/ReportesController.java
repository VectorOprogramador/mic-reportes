package com.perfulandia.mic_reportes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<List<Reportes>> getAllResenas() {
        List<Reportes> resenas = reportesService.findAll(); // Corregido: instancia, no estático
        return resenas.isEmpty() 
            ? new ResponseEntity<>(HttpStatus.NO_CONTENT) 
            : new ResponseEntity<>(resenas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reportes> getResenaById(@PathVariable Long id) {
        if (reportesService.existsById(id)) {
            return new ResponseEntity<>(reportesService.findById(id).get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
