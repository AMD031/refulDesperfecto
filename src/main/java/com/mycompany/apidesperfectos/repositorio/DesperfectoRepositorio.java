/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apidesperfectos.repositorio;

import com.mycompany.apidesperfectos.modelo.Desperfecto;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author AMD
 */
@Repository
public interface DesperfectoRepositorio
        extends JpaRepository<Desperfecto, Long> {

    
    
    
}
