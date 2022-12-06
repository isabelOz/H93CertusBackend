package com.example.backendh93p1.services;

import com.example.backendh93p1.entity.Categoria;
import com.example.backendh93p1.entity.Examen;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ExamenService {

    Examen agregarExamen(Examen examen);

    Examen actualizarExamen(Examen examen);

    Set<Examen> obtenerExamenes();

    Examen obtenerExamen(Long examenId);

    void eliminarExamen(Long examenId);

    List<Examen> listarExamenesDeUnaCategoria(Categoria categoria);

    List<Examen> obtenerExamenesActivos();

    List<Examen> obtenerExamenesActivosDeUnaCategoria(Categoria categoria);
}
