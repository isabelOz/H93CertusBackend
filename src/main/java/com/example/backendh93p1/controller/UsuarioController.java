package com.example.backendh93p1.controller;

import com.example.backendh93p1.entity.RolEntity;
import com.example.backendh93p1.entity.UsuarioRolEntity;
import com.example.backendh93p1.entity.UsuariosEntity;
import com.example.backendh93p1.repository.UsuarioRepository;
import com.example.backendh93p1.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("http://localhost:4200/")
public class UsuarioController {

    @Autowired
    private UsuarioServices userService;

    @GetMapping (value = "/{username}")
    public UsuariosEntity obtenerUsuario (@PathVariable("username") String username){
        UsuariosEntity userlocal = new UsuariosEntity();
        userlocal = userService.obtenerUsuarioService(username);
        return userlocal;
    }


    @PostMapping("/registrarUsuario")
    public UsuariosEntity agregarUsuario (@RequestBody UsuariosEntity userJsonEntity) throws Exception{

         Set<UsuarioRolEntity> userRolController =  new HashSet<>();

         RolEntity rol = new RolEntity();
         rol.setIdrol(1);
         rol.setNombrol("Cliente");

         UsuarioRolEntity userrol = new UsuarioRolEntity();
         userrol.setUsuariorol(userJsonEntity);
         userrol.setRolusario(rol);

        userRolController.add(userrol);

        return userService.guardarUsuarioService(userJsonEntity,userRolController);
    }
}
