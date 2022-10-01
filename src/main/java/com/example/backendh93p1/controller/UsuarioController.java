package com.example.backendh93p1.controller;

import com.example.backendh93p1.entity.RolEntity;
import com.example.backendh93p1.entity.UsuarioRolEntity;
import com.example.backendh93p1.entity.UsuariosEntity;
import com.example.backendh93p1.interfa.UsuarioInterface;
import com.example.backendh93p1.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioInterface userInterface;
    private UsuarioRepository userRepo;

    @GetMapping (value = "/{username}")
    public UsuariosEntity obtenerUsuario (@PathVariable("username") String username){
        return userRepo.buscarUsuarioRepository(username);
    }

    @PostMapping
    public UsuariosEntity agregarUsuario (@RequestBody UsuariosEntity userJsonEntity) throws Exception{

         Set<UsuarioRolEntity> userRolController =  new HashSet<>();

         RolEntity rol = new RolEntity();
         rol.setIdrol(1);
         rol.setNombrol("Cliente");

         UsuarioRolEntity userrol = new UsuarioRolEntity();
         userrol.setUsuariorol(userJsonEntity);
         userrol.setRolusario(rol);

        userRolController.add(userrol);
        return userInterface.guardarUsuario(userJsonEntity,userRolController);
    }

}
