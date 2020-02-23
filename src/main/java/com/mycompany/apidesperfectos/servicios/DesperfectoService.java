/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apidesperfectos.servicios;

import com.mycompany.apidesperfectos.excepcion.RecordNotFoundException;
import com.mycompany.apidesperfectos.intefaces.IDesperfecto;
import com.mycompany.apidesperfectos.intefaces.IUsuario;
import com.mycompany.apidesperfectos.modelo.Desperfecto;
import com.mycompany.apidesperfectos.modelo.Usuario;
import com.mycompany.apidesperfectos.repositorio.DesperfectoRepositorio;
import com.mycompany.apidesperfectos.repositorio.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Antonio Martinez Diaz
 */
@Service
public class DesperfectoService {
    @Autowired
    DesperfectoRepositorio repositorio;
    
    
    @Autowired
    UsuarioRepositorio repositorioUsuario;
     
    public List<Desperfecto> getAllDesperfectos()
    {
        List<Desperfecto> desperfectoList = repositorio.findAll();
         
        if(desperfectoList.size() > 0) {
            return desperfectoList;
        } else {
            return new ArrayList<Desperfecto>();
        }
    }
     
    public Desperfecto getDesperfectoById(Long id) throws RecordNotFoundException
    {
        Optional<Desperfecto> desperfecto = repositorio.findById(id);
         
        if(desperfecto.isPresent()) {
            return desperfecto.get();
        } else {
            throw new RecordNotFoundException("No desperfecto record exist for given id",id);
        }
    }
  
   public Desperfecto UpdateDesperfecto(Desperfecto entity) throws RecordNotFoundException
    {
    	    	
    	if(entity.getId_desperfecto()!=null)
    	{
    	  Optional<Desperfecto> desperfecto = repositorio.findById(entity.getId_desperfecto());
        
            if(desperfecto.isPresent())
            {
                Desperfecto newEntity = desperfecto.get();
                newEntity.setLatitud(entity.getLatitud());
                newEntity.setLongitud(entity.getLongitud());
                newEntity.setFoto(entity.getFoto());
                newEntity.setFecha(entity.getFecha());
                newEntity.setDescripcion(entity.getDescripcion());
                newEntity = repositorio.save(newEntity);
                return newEntity;
            } else {
                throw new RecordNotFoundException("Desperfecto not found",entity.getId_desperfecto());
            }
        }else{
    		throw new RecordNotFoundException("No id of desperfecto given",0l);
    	}	    
    }
     
    public void deleteDesperfectoById(Long id) throws RecordNotFoundException
    {
        Optional<Desperfecto> desperfecto = repositorio.findById(id);
         
        if(desperfecto.isPresent())
        {
            repositorio.deleteById(id);
        } else {
            throw new RecordNotFoundException("No desperfecto record exist for given id",id);
        }
    }

   /* public List<Desperfecto> getDesperfectosByTitle(String title) {
        List<Desperfecto> desperfectoList = repositorio.getByTitle(title);
         
        if(desperfectoList.size() > 0) {
            return desperfectoList;
        } else {
            return new ArrayList<Desperfecto>();
        }
    }*/

    @Transactional
    public Desperfecto createDesperfecto(Long id_usuario, Desperfecto desperfecto) {
        Optional<Usuario> usuario = repositorioUsuario.findById(id_usuario);
       
    if (usuario.isPresent()) {
            Usuario usuarioEditada = usuario.get();
            desperfecto.setUsuario(usuarioEditada);    
            desperfecto = repositorio.save(desperfecto);
            usuarioEditada.addDesperfecto(desperfecto);
            return desperfecto;
        } else {
            throw new RecordNotFoundException("marca not found", id_usuario);
        }
    
    }

    public List<IUsuario> getUsaurioByIdDesperfecto(Long id) {
      
         List<IUsuario> desperfectos = repositorio.getUsaurioByIdDesperfecto(id);
        if (desperfectos.size() > 0) {
            return desperfectos;
        } else {
            return new ArrayList<IUsuario>();
        }
        
        
        
    }

    public List<Desperfecto> getDesperfectoByFecha(String fecha) {
        List<Desperfecto> desperfectos = repositorio.getDesperfectoByFecha(fecha);
        if (desperfectos.size() > 0) {
            return desperfectos;
        } else {
            return new ArrayList<Desperfecto>();
        }
        
    }


  
    
}
