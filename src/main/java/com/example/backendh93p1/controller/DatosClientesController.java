package com.example.backendh93p1.controller;

import com.example.backendh93p1.entity.DatosClientesEntity;
import com.example.backendh93p1.interfa.DatosClientesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void crearDatoCliente (@RequestBody DatosClientesEntity DatCliEnt){
        datosClientesInterface.save(DatCliEnt);
    }

    @PutMapping
    public void actualizarDatoCliente (@RequestBody DatosClientesEntity DatCliEnt){
        datosClientesInterface.save(DatCliEnt);
    }

    @DeleteMapping (value = "/{id}")
    public void eliminarDatoCliente (@PathVariable ("id") Integer id){
        datosClientesInterface.deleteById(id);
    }


    @PutMapping (value = "/{id}")
    public ResponseEntity <DatosClientesEntity>  actualizarDatoClienteEspecifico (@PathVariable ("id") Integer id, @RequestBody DatosClientesEntity DatCliEntJson){
        DatosClientesEntity DatCliEntBD = datosClientesInterface.findById(id).orElseThrow();

        //Apellido Vacio
        if (!(DatCliEntJson.getApellCliente() == null)){
            DatCliEntBD.setApellCliente(DatCliEntJson.getApellCliente());
        }

        //Correo Vacio
        if (!(DatCliEntJson.getCorreoCliente() == null)){
            DatCliEntBD.setCorreoCliente(DatCliEntJson.getCorreoCliente());
        }
        //Nombre Vacio
        if (!(DatCliEntJson.getNombCliente() == null)){
            DatCliEntBD.setNombCliente(DatCliEntJson.getNombCliente());
        }

        //DNI Vacio
        if (!(DatCliEntJson.getDniCliente() == null)){
            DatCliEntBD.setDniCliente(DatCliEntJson.getDniCliente());
        }

        DatosClientesEntity DatCliEntBDActu = datosClientesInterface.save(DatCliEntBD);

        return ResponseEntity.ok(DatCliEntBDActu);
    }
}
