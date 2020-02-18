/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apidesperfectos.servicios;

import com.mycompany.apidesperfectos.excepcion.RecordNotFoundException;
import com.mycompany.apidesperfectos.intefaces.IDesperfecto;
import com.mycompany.apidesperfectos.modelo.Usuario;
import com.mycompany.apidesperfectos.repositorio.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Antonio Martinez Diaz
 */
@Service
public class UsuarioService {
    @Autowired
    UsuarioRepositorio repositorio;
    
    @Autowired 
    DesperfectoService desperfectoservice;
     
    public List<Usuario> getAllUsuarios()
    {
        List<Usuario> desperfectoList = repositorio.findAll();
         
        if(desperfectoList.size() > 0) {
            return desperfectoList;
        } else {
            return new ArrayList<Usuario>();
        }
    }
     
    public Usuario getUsuarioById(Long id) throws RecordNotFoundException
    {
        Optional<Usuario> desperfecto = repositorio.findById(id);
         
        if(desperfecto.isPresent()) {
            return desperfecto.get();
        } else {
            throw new RecordNotFoundException("No desperfecto record exist for given id",id);
        }
    }
    public Usuario createUsuario(Usuario entity){
        entity = repositorio.save(entity);
        return entity;
    }
    /*public Usuario UpdateUsuario(Usuario entity) throws RecordNotFoundException
    {
    	    	
    	if(entity.getId()!=null)
    	{
    	  Optional<Usuario> desperfecto = repositorio.findById(entity.getId());
        
            if(desperfecto.isPresent())
            {
                Usuario newEntity = desperfecto.get();
                //newEntity.setId(entity.getId());
                newEntity.setTitle(entity.getTitle());
                newEntity.setDescription(entity.getDescription());

                newEntity = repositorio.save(newEntity);

                return newEntity;
            } else {
                throw new RecordNotFoundException("Usuario not found",entity.getId());
            }
        }else{
    		throw new RecordNotFoundException("No id of desperfecto given",0l);
    	}	    
 }*/
     
    public void deleteUsuarioById(Long id) throws RecordNotFoundException
    {
        Optional<Usuario> desperfecto = repositorio.findById(id);
         
        if(desperfecto.isPresent())
        {
            repositorio.deleteById(id);
        } else {
            throw new RecordNotFoundException("No desperfecto record exist for given id",id);
        }
    }

   /* public List<Usuario> getUsuariosByTitle(String title) {
        List<Usuario> desperfectoList = repositorio.getByTitle(title);
         
        if(desperfectoList.size() > 0) {
            return desperfectoList;
        } else {
            return new ArrayList<Usuario>();
        }
    }*/

    public List<IDesperfecto> getDesperfectoByIdUsuario(Long id) {
        List<IDesperfecto> desperfectos = repositorio.getDesperfectosByIdUsuario(id);
        if (desperfectos.size() > 0) {
            return desperfectos;
        } else {
            return new ArrayList<IDesperfecto>();
        }
        
        
    }

    public List<IDesperfecto> getDesperfectoByEmail(String email) {
        
        List<IDesperfecto> desperfectos = repositorio.getDesperfectoByEmail(email);
        if (desperfectos.size() > 0) {
            return desperfectos;
        } else {
            return new ArrayList<IDesperfecto>();
        }
        
      
    }
    
      public List<IDesperfecto> getDesperfectoByNombreUsuario(String nombre) {
        List<IDesperfecto> desperfectos = repositorio.getDesperfectoByNombreUsuario(nombre);
        if (desperfectos.size() > 0) {
            return desperfectos;
        } else {
            return new ArrayList<IDesperfecto>();
        } 
    }
  
    
}
