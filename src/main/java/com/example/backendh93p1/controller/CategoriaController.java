package com.example.backendh93p1.controller;

import com.example.backendh93p1.entity.Categoria;
import com.example.backendh93p1.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

    @Autowired
    private CategoriaService  categoriaService;

    @GetMapping ("/listar")
    public ResponseEntity<?> listarCategoria (){
        return ResponseEntity.ok(categoriaService.obtenerCategorias());
    }

    @GetMapping ("/listar/{idCategoria}")
    public Categoria listarCategoriaId (@PathVariable ("idCategoria") Long idCategoria){
        return categoriaService.obtenerCategoria(idCategoria);
    }

    @PostMapping ("/agregar")
    public ResponseEntity<Categoria> agregarCategoria (@RequestBody  Categoria categoria){
        Categoria categorianueva = categoriaService.agregarCategoria(categoria);
        return  ResponseEntity.ok(categorianueva);
    }
}
