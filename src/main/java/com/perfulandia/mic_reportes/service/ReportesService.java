package com.perfulandia.mic_reportes.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.perfulandia.mic_reportes.model.Reportes;
import com.perfulandia.mic_reportes.repository.ReportesRepository;

@Service
public class ReportesService {
    @Autowired
    private ReportesRepository reportesRepository;

    public List<Reportes> findAll() {
        return reportesRepository.findAll();
    }

    public Optional<Reportes> findById(Long id) {
        return reportesRepository.findById(id);
    }

    public boolean existsById(Long id) {
        return reportesRepository.existsById(id);
    }
}
