package com.perfulandia.mic_reportes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.mic_reportes.model.Reportes;

public interface ReportesRepository extends JpaRepository<Reportes, Long> {
    List<Reportes> findAll();
    Optional<Reportes> findById(Long id);
    boolean existsById(Long id);
}
