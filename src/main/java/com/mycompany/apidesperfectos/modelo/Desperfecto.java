/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apidesperfectos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Antonio Martinez Diaz
 */

@Entity
@Table(name = "Desperfecto")
public class Desperfecto implements Serializable{
    private static final long serialVersionUID = 1L;
   
    @Id
    @Column(name = "id_desperfecto",updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_desperfecto;
    
    @NotNull
    @Column(name = "latitud")
    private Double latitud;
   
    @NotNull
    @Column(name = "longitud")
    private Double longitud;
    
    @Column(name = "foto")
    private String foto;
    
    @Column(name = "fecha")
    private Timestamp fecha;
    
    @Column(name = "descripcion")
    String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_fk")
    @JsonIgnore
    private Usuario usuario;

    public Long getId_desperfecto() {
        return id_desperfecto;
    }

    public Double getLatitud() {
        return latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public String getFoto() {
        return foto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setId_desperfecto(Long id_desperfecto) {
        this.id_desperfecto = id_desperfecto;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        if(fecha ==null){
            fecha = new Timestamp(System.currentTimeMillis());
        }
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id_desperfecto);
        hash = 19 * hash + Objects.hashCode(this.latitud);
        hash = 19 * hash + Objects.hashCode(this.longitud);
        hash = 19 * hash + Objects.hashCode(this.foto);
        hash = 19 * hash + Objects.hashCode(this.fecha);
        hash = 19 * hash + Objects.hashCode(this.descripcion);
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
        final Desperfecto other = (Desperfecto) obj;
        if (!Objects.equals(this.foto, other.foto)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.id_desperfecto, other.id_desperfecto)) {
            return false;
        }
        if (!Objects.equals(this.latitud, other.latitud)) {
            return false;
        }
        if (!Objects.equals(this.longitud, other.longitud)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

   
    

  
   
    
   
    
}
