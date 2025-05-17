package com.perfulandia.mic_reportes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perfulandia.mic_reportes.model.Reportes;

/**
 * Repositorio para la gestión de entidades Reportes en la base de datos.
 * Proporciona operaciones CRUD básicas y métodos de consulta personalizados.
 */
public interface ReportesRepository extends JpaRepository<Reportes, Long> {
    /**
     * Recupera todos los registros de reportes existentes en la base de datos.
     * 
     * @return Lista con todas las entidades Reportes encontradas.
     *         La lista será vacía si no existen registros.
     */
    List<Reportes> findAll();
    
    /**
     * Busca un reporte por su identificador único.
     * 
     * param id Identificador único del reporte a buscar.
     * return Un Optional que contiene la entidad Reportes si se encuentra,
     *         o un Optional vacío si no existe.
     */
    Optional<Reportes> findById(Long id);
    
    /**
     * Verifica la existencia de un reporte con el identificador especificado.
     * 
     * param id Identificador único del reporte a verificar.
     * return true si existe un reporte con el ID proporcionado,
     *         false en caso contrario.
     */
    boolean existsById(Long id);
}
