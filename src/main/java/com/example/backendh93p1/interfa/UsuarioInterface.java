package com.example.backendh93p1.interfa;

import com.example.backendh93p1.entity.UsuarioRolEntity;
import com.example.backendh93p1.entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UsuarioInterface extends JpaRepository<UsuariosEntity,Integer> {
    public UsuariosEntity guardarUsuario (UsuariosEntity userEntity,  Set<UsuarioRolEntity> userrol ) throws Exception;
}
