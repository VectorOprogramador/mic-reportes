package com.perfulandia.mic_reportes.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.ArrayList;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "reportes_usuarios_activos")
public class ReporteUsuariosActivos extends Reportes {
    @ElementCollection
    @CollectionTable(name = "reporte_usuarios_items", joinColumns = @JoinColumn(name = "reporte_id"))
    private ArrayList<String> listaUsuariosActivos = new ArrayList<>();

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Override
    public void crearReporte() {
        this.setEstado("EN_PROCESO");
        // Lógica para recolectar usuarios activos
        System.out.println("Generando reporte de usuarios activos...");
        
        // Simulación de datos recolectados
        listaUsuariosActivos.add("Usuario1 - Activo desde 2025-01-01");
        listaUsuariosActivos.add("Usuario2 - Activo desde 2025-02-15");
        
        this.setMensaje("Reporte de usuarios activos generado con " + listaUsuariosActivos.size() + " usuarios");
        this.setEstado("COMPLETADO");
    }

    @Override
    public void exportar(String formato) {
        System.out.println("Exportando reporte de usuarios activos en formato " + formato);
        // Implementación específica para usuarios activos
    }
}