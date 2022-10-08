package com.example.backendh93p1.services.implement;

import com.example.backendh93p1.entity.UsuarioRolEntity;
import com.example.backendh93p1.entity.UsuariosEntity;
import com.example.backendh93p1.repository.RolRepository;
import com.example.backendh93p1.repository.UsuarioRepository;
import com.example.backendh93p1.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServicesImpl implements UsuarioServices {

    @Autowired
    private UsuarioRepository userRepo;

    @Autowired
    private RolRepository rolRepo;

    @Override
    public UsuariosEntity guardarUsuarioService(UsuariosEntity usuariosJson, Set<UsuarioRolEntity> usuarioRolController) throws Exception {

        UsuariosEntity userlocal = userRepo.findByUsername(usuariosJson.getUsername());
        if (userlocal != null) {
            System.out.println("Usuario ya existe");
        } else {
            for(UsuarioRolEntity usuarioRolEntity:usuarioRolController){
                rolRepo.save(usuarioRolEntity.getRolusario());
            }
            usuariosJson.getUsuariorolentity().addAll(usuarioRolController);
            userlocal = userRepo.save(usuariosJson);
        }
        return userlocal;
    }

    @Override
    public UsuariosEntity obtenerUsuarioService(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public void eliminarUsuarioService(int idusurios) {

    }

}