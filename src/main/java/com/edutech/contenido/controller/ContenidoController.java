package com.edutech.contenido.controller;

import com.edutech.contenido.model.Contenido;
import com.edutech.contenido.service.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contenidos")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @PostMapping
    public ResponseEntity<Contenido> crearContenido(@RequestBody Contenido contenido) {
        return ResponseEntity.ok(contenidoService.guardarContenido(contenido));
    }

    @GetMapping
    public ResponseEntity<List<Contenido>> listarContenidos() {
        return ResponseEntity.ok(contenidoService.listarContenidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contenido> obtenerContenido(@PathVariable Long id) {
        return contenidoService.obtenerContenidoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contenido> actualizarContenido(@PathVariable Long id, @RequestBody Contenido contenido) {
        return ResponseEntity.ok(contenidoService.actualizarContenido(id, contenido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContenido(@PathVariable Long id) {
        contenidoService.eliminarContenido(id);
        return ResponseEntity.noContent().build();
    }
}
