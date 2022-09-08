package com.example.backendh93p1.controller;

import com.example.backendh93p1.entity.DatosClientesEntity;
import com.example.backendh93p1.interfa.DatosClientesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/datocliente")
public class DatosClientesController {

    @Autowired
    private DatosClientesInterface datosClientesInterface;

    @GetMapping
    public List<DatosClientesEntity> busquedaDatoCliente (){
        return (List<DatosClientesEntity>) datosClientesInterface.findAll();
    }
}
