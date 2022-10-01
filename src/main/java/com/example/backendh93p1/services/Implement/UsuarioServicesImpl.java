package com.example.backendh93p1.services.Implement;

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
    public UsuariosEntity guardarUsuario(UsuariosEntity usuariosJson, Set<UsuarioRolEntity> usuarioRolController) throws Exception {
        UsuariosEntity userlocal = userRepo.buscarUsuarioRepository(usuariosJson.getUsername());
        if (userlocal != null) {
            System.out.println("Usuario ya existe");

        } else {
            for(UsuarioRolEntity usuarioRolEntity:usuarioRolController){
                rolRepo.save(usuarioRolEntity.getRolusario());

            }
        }
    }
}