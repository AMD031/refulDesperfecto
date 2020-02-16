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
   @Query( value = "SELECT ID_DESPERFECTO,FOTO ,LATITUD,LONGITUD FROM DESPERFECTO  INNER JOIN  USUARIO  ON  USUARIO.Id_usuario = DESPERFECTO.id_usuario_fk" ,nativeQuery = true)
    public List<IDesperfecto> getDesperfectoByIdUsuario(Long id);

    
    
    
}
