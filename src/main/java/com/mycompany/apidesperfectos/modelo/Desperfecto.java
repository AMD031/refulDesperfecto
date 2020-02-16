/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apidesperfectos.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Antonio Martinez Diaz
 */

@Entity
@Table(name = "Desperfecto")
public class Desperfecto{
    @Id
    @Column(name = "id_desperfecto",updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_desperfecto;
    
    @Column(name = "latitud")
    private Double latitud;
    
    @Column(name = "longitud")
    private Double longitud;
    
    @Column(name = "foto")
    private String foto;
    
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

  
   
    
   
    
}
