package com.example.backendh93p1.repository;

import com.example.backendh93p1.entity.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <UsuariosEntity,Integer> {

    public UsuariosEntity buscarUsuarioRepository (String username);
}
