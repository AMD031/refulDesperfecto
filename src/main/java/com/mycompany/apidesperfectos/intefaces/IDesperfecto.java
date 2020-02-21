/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apidesperfectos.intefaces;

import com.mycompany.apidesperfectos.modelo.Usuario;
import java.sql.Timestamp;

/**
 *
 * @author Antonio Martínez Díaz
 */
public interface IDesperfecto {
  
    public Long getId_desperfecto();
    public Double getLatitud();
    public Double getLongitud();
    public String getFoto();
    public Timestamp getFecha();
   //public Usuario getUsuario();
    
    
}
