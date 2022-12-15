package com.example.backendh93p1.controller;

import com.example.backendh93p1.entity.DatosClientesEntity;
import com.example.backendh93p1.repository.DatosClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/datocliente")
@CrossOrigin("*")
public class DatosClientesController {

    @Autowired
    private DatosClientesRepository datosClientesRepository;

    @GetMapping ("/listar")
    public List<DatosClientesEntity> busquedaDatoCliente (){
        return (List<DatosClientesEntity>) datosClientesRepository.findAll();
    }

    @PostMapping ("/insertar")
    public void crearDatoCliente (@RequestBody DatosClientesEntity DatCliEnt){
        datosClientesRepository.save(DatCliEnt);
    }

    @PutMapping ("/modificar")
    public void actualizarDatoCliente (@RequestBody DatosClientesEntity DatCliEnt){
        datosClientesRepository.save(DatCliEnt);
    }

    @DeleteMapping (value = "/eliminar/{id}")
    public void eliminarDatoCliente (@PathVariable ("id") Integer id){
        datosClientesRepository.deleteById(id);
    }


    @PutMapping (value = "/modificardato/{id}")
    public ResponseEntity <DatosClientesEntity>  actualizarDatoClienteEspecifico (@PathVariable ("id") Integer id, @RequestBody DatosClientesEntity DatCliEntJson){
        DatosClientesEntity DatCliEntBD = datosClientesRepository.findById(id).orElseThrow();

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

        DatosClientesEntity DatCliEntBDActu = datosClientesRepository.save(DatCliEntBD);

        return ResponseEntity.ok(DatCliEntBDActu);
    }
}
