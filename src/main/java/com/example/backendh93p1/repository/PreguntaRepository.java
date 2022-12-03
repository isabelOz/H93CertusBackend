package com.example.backendh93p1.repository;

import com.example.backendh93p1.entity.Examen;
import com.example.backendh93p1.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta,Long> {
    Set<Pregunta> findByExamen(Examen examen);
}
