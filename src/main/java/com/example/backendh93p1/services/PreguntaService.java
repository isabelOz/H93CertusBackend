package com.example.backendh93p1.services;

import com.example.backendh93p1.entity.Examen;
import com.example.backendh93p1.entity.Pregunta;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface PreguntaService {

    Pregunta agregarPregunta(Pregunta pregunta);

    Pregunta actualizarPregunta(Pregunta pregunta);

    Set<Pregunta> obtenerPreguntas();

    Pregunta obtenerPregunta(Long preguntaId);

    Set<Pregunta> obtenerPreguntasDelExamen(Examen examen);

    void eliminarPregunta(Long preguntaId);

    Pregunta listarPregunta(Long preguntaId);
}
