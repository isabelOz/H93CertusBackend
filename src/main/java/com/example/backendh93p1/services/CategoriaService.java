package com.example.backendh93p1.services;

import com.example.backendh93p1.entity.Categoria;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface CategoriaService {

    Categoria agregarCategoria(Categoria categoria);

    Categoria actualizarCategoria(Categoria categoria);

    Set<Categoria> obtenerCategorias();

    Categoria obtenerCategoria(Long categoriaId);

    void eliminarCategoria(Long categoriaId);
}
