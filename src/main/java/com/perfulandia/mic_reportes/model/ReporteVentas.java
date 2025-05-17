package com.perfulandia.mic_reportes.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.ArrayList;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "reportes_ventas")
public class ReporteVentas extends Reportes {
    @ElementCollection
    @CollectionTable(name = "reporte_ventas_items", joinColumns = @JoinColumn(name = "reporte_id"))
    private ArrayList<String> listaVentas = new ArrayList<>();

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Override
    public void crearReporte() {
        this.setEstado("EN_PROCESO");
        // Lógica para recolectar datos de ventas entre las fechas
        System.out.println("Recolectando datos de ventas desde " + fechaInicio + " hasta " + fechaFin);
        
        // Simulación de datos recolectados
        listaVentas.add("Venta 1 - $100");
        listaVentas.add("Venta 2 - $200");
        
        this.setMensaje("Reporte de ventas generado con " + listaVentas.size() + " registros");
        this.setEstado("COMPLETADO");
    }

    @Override
    public void exportar(String formato) {
        System.out.println("Exportando reporte de ventas en formato " + formato);
        switch (formato.toLowerCase()) {
            case "pdf":
                System.out.println("Generando PDF...");
                break;
            case "excel":
                System.out.println("Generando Excel...");
                break;
            case "csv":
                System.out.println("Generando CSV...");
                break;
            default:
                System.out.println("Formato no soportado");
        }
    }
}