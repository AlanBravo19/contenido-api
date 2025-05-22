package com.edutech.contenido.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private String tipo; // video, pdf, texto, etc.
    private String url;

    // Opcional: puedes agregar fecha de creación, autor, etc.
}
