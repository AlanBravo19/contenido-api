package com.edutech.contenido.service;

import com.edutech.contenido.model.Contenido;
import java.util.List;
import java.util.Optional;

public interface ContenidoService {

    Contenido guardarContenido(Contenido contenido);
    
    List<Contenido> listarContenidos();
    
    Optional<Contenido> obtenerContenidoPorId(Long id);
    
    Contenido actualizarContenido(Long id, Contenido contenido);
    
    void eliminarContenido(Long id);
}