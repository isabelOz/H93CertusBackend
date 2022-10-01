package com.example.backendh93p1.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "rol")
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrol;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "")
    private Set<UsuarioRolEntity> usuariorolentity = new HashSet<>();

    public Set<UsuarioRolEntity> getUsuariorolentity() {
        return usuariorolentity;
    }

    public void setUsuariorolentity(Set<UsuarioRolEntity> usuariorolentity) {
        this.usuariorolentity = usuariorolentity;
    }

    private String nombrol;

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getNombrol() {
        return nombrol;
    }

    public void setNombrol(String nombrol) {
        this.nombrol = nombrol;
    }

    public RolEntity(){

    }
}
