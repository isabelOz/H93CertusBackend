package com.example.backendh93p1.services;

import com.example.backendh93p1.entity.UsuarioRolEntity;
import com.example.backendh93p1.entity.UsuariosEntity;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface UsuarioServices {

    public UsuariosEntity guardarUsuarioService (UsuariosEntity usuariosEntity, Set<UsuarioRolEntity> usuarioRolEntity) throws Exception;

    public UsuariosEntity obtenerUsuarioService (String username);

    public void eliminarUsuarioService (int idusurios);

}
