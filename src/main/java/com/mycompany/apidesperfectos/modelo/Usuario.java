/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apidesperfectos.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Antonio Martínez Díaz
 */

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable{
   
    @Id
    @Column(name = "id_usuario",updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    
    @Column(name = "email")
    private String email;
    @Column(name = "nombre_usuario")
    private String nombre_usuario;
    @Column(name="url_imagen")
    private String url_imagen;

    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)       
    Set<Desperfecto> desperfectos = new HashSet<>();;

    public Long getId_usuario() {
        return id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getUrl_imagen() {
        return url_imagen;
    }

    public Set<Desperfecto> getDesperfectos() {
        return desperfectos;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setUrl_imagen(String url_imagen) {
        this.url_imagen = url_imagen;
    }

    public void setDesperfectos(Set<Desperfecto> desperfectos) {
        this.desperfectos = desperfectos;
    }

   public void addDesperfecto(Desperfecto desperfecto) {
        if (  this.desperfectos== null) {
              this.desperfectos= new HashSet<>();
        }
          this.desperfectos.add(desperfecto);
          desperfecto.setUsuario(this);
    }

      
    public void removeDesperfecto(Desperfecto desperfecto) {
        if (this.desperfectos == null) {
            this.desperfectos = new HashSet<>();
        }
        this.desperfectos.remove(desperfecto);
        desperfecto.setUsuario(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id_usuario);
        hash = 41 * hash + Objects.hashCode(this.email);
        hash = 41 * hash + Objects.hashCode(this.nombre_usuario);
        hash = 41 * hash + Objects.hashCode(this.url_imagen);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nombre_usuario, other.nombre_usuario)) {
            return false;
        }
        if (!Objects.equals(this.url_imagen, other.url_imagen)) {
            return false;
        }
        if (!Objects.equals(this.id_usuario, other.id_usuario)) {
            return false;
        }
        return true;
    }

   
     
    
    

 
    
}
