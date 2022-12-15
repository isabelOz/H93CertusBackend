package com.example.backendh93p1.controller;

import com.example.backendh93p1.entity.Examen;
import com.example.backendh93p1.services.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examen")
@CrossOrigin("*")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @GetMapping
    public List<Examen> busquedaexamen (){
        return (List<Examen>) examenService.obtenerExamenes();
    }

    @PostMapping
    public void creaexamen (@RequestBody Examen examenClient){
        examenService.agregarExamen(examenClient);
    }

    @PutMapping
    public  void actualizarExamen (@RequestBody Examen examenClient){
        examenService.actualizarExamen(examenClient);
    }

    @GetMapping (value = "{idexamen}")
    public Examen obtenerExamenId (@PathVariable ("idexamen") Long idexamen){
        return examenService.obtenerExamen(idexamen);
    }

}
