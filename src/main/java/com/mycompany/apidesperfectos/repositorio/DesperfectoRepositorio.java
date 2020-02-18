/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apidesperfectos.repositorio;

import com.mycompany.apidesperfectos.intefaces.IUsuario;
import com.mycompany.apidesperfectos.modelo.Desperfecto;
import java.util.List;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AMD
 */
@Repository
public interface DesperfectoRepositorio
        extends JpaRepository<Desperfecto, Long> {
    
    @Query(value = "SELECT id_usuario,email,NOMBRE_USUARIO, URL_IMAGEN,fecha   FROM DESPERFECTO  INNER JOIN  USUARIO  ON  USUARIO.Id_usuario = DESPERFECTO.id_usuario_fk where  desperfecto.ID_DESPERFECTO  =?", nativeQuery = true)
    public List<IUsuario> getUsaurioByIdDesperfecto(Long id);

    
 

    
    
    
}
