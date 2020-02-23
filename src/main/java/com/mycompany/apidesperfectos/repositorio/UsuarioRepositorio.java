/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apidesperfectos.repositorio;

import com.mycompany.apidesperfectos.intefaces.IDesperfecto;

import com.mycompany.apidesperfectos.modelo.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AMD
 */
@Repository
public interface UsuarioRepositorio
        extends JpaRepository<Usuario, Long> {
    @Query( value = "SELECT ID_DESPERFECTO,FOTO ,LATITUD,LONGITUD, fecha, descripcion FROM DESPERFECTO  INNER JOIN  USUARIO  ON  USUARIO.Id_usuario = DESPERFECTO.id_usuario_fk where USUARIO.Id_usuario = ? " ,nativeQuery = true)
    public List<IDesperfecto> getDesperfectosByIdUsuario(Long id);

    @Query( value = "SELECT ID_DESPERFECTO,FOTO ,LATITUD,LONGITUD, fecha, descripcion FROM DESPERFECTO  INNER JOIN  USUARIO  ON  USUARIO.Id_usuario = DESPERFECTO.id_usuario_fk where USUARIO.email like %?1%" ,nativeQuery = true)
    public List<IDesperfecto> getDesperfectoByEmail(String email);
 
    @Query( value =  "SELECT ID_DESPERFECTO,FOTO ,LATITUD,LONGITUD, fecha, descripcion FROM DESPERFECTO  INNER JOIN  USUARIO  ON  USUARIO.Id_usuario = DESPERFECTO.id_usuario_fk where USUARIO.NOMBRE_USUARIO like %?1%" ,nativeQuery = true)
    public List<IDesperfecto> getDesperfectoByNombreUsuario(String nombre);

    @Query( value =  "SELECT distinct ID_DESPERFECTO,FOTO ,LATITUD,LONGITUD, fecha, descripcion FROM DESPERFECTO  INNER JOIN  USUARIO ON  USUARIO.Id_usuario = DESPERFECTO.id_usuario_fk where  USUARIO.email like %?1% or usuario.nombre_usuario like %?2%" ,nativeQuery = true)
    public List<IDesperfecto> getDesperfectoByNombreUsuarioOrEmail(String valor1, String valor2);
    
    
}
