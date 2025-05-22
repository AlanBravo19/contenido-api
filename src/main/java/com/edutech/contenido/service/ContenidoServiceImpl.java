package com.edutech.contenido.service;

import com.edutech.contenido.model.Contenido;
import com.edutech.contenido.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContenidoServiceImpl implements ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Override
    public Contenido guardarContenido(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    @Override
    public List<Contenido> listarContenidos() {
        return contenidoRepository.findAll();
    }

    @Override
    public Optional<Contenido> obtenerContenidoPorId(Long id) {
        return contenidoRepository.findById(id);
    }

    @Override
    public Contenido actualizarContenido(Long id, Contenido contenido) {
        Contenido existente = contenidoRepository.findById(id).orElseThrow(() ->
            new RuntimeException("Contenido no encontrado con ID: " + id)
        );
        existente.setTitulo(contenido.getTitulo());
        existente.setDescripcion(contenido.getDescripcion());
        existente.setTipo(contenido.getTipo());

        return contenidoRepository.save(existente);
    }

    @Override
    public void eliminarContenido(Long id) {
        contenidoRepository.deleteById(id);
    }
}
