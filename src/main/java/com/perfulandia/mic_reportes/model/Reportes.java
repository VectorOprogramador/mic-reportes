package com.perfulandia.mic_reportes.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reportes")
public class Reportes {
    // ARCHIVO TRABAJADO 14/05/2025 A LAS 20:47
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mensajereporte", nullable = false)
    private String mensajereporte;

    @Column(name = "fechareporte", nullable = false)
    private Date fechareporte;

}



