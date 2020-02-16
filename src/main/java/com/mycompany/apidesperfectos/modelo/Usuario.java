/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apidesperfectos.modelo;

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
public class Usuario {
   
    @Id
    @Column(name = "id_usuario",updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    
    @Column(name = "email")
    private String email;
    @Column(name = "nombreUsuario")
    private String nombreUsuario;
    @Column(name="urlImage")
    private String urlImage;

    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)       
    Set<Desperfecto> desperfectos = new HashSet<>();;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Set<Desperfecto> getDesperfectos() {
        return desperfectos;
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
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id_usuario);
        hash = 23 * hash + Objects.hashCode(this.email);
        hash = 23 * hash + Objects.hashCode(this.nombreUsuario);
        hash = 23 * hash + Objects.hashCode(this.urlImage);
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
        if (!Objects.equals(this.nombreUsuario, other.nombreUsuario)) {
            return false;
        }
        if (!Objects.equals(this.urlImage, other.urlImage)) {
            return false;
        }
        if (!Objects.equals(this.id_usuario, other.id_usuario)) {
            return false;
        }
        return true;
    }

 

     
    
    

 
    
}
