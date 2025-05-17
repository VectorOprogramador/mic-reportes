package com.perfulandia.mic_reportes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "reportes")
public abstract class Reportes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mensaje", nullable = false)
    private String mensaje;

@Column(name = "fecha_generacion", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
private LocalDateTime fechaGeneracion;

    @Column(name = "estado", nullable = false)
    private String estado = "PENDIENTE"; // PENDIENTE, EN_PROCESO, COMPLETADO

    public abstract void crearReporte();
    public abstract void exportar(String formato); // Ahora acepta el formato de exportación
}