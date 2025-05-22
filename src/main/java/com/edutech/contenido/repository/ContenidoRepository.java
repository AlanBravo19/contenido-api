package com.edutech.contenido.repository;

import com.edutech.contenido.model.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Long> {
    
    // List<Contenido> findByTipo(String tipo);
}
