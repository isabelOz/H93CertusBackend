package com.example.backendh93p1.services;

import com.example.backendh93p1.entity.UsuarioRolEntity;
import com.example.backendh93p1.entity.UsuariosEntity;

import java.util.Set;

public interface UsuarioServices {

    /*Metodo Post*/
    public UsuariosEntity guardarUsuario (UsuariosEntity usuariosEntity, Set<UsuarioRolEntity> usuarioRolEntity) throws Exception;

    /*Metodo Get*/
    public UsuariosEntity obtenerUsuario (String username);

    /*Metodo $$$$$$$*/
    public void eliminarUsuario (int idusurios);

}
