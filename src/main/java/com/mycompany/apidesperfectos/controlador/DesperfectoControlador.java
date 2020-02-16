/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apidesperfectos.controlador;

import com.mycompany.apidesperfectos.excepcion.RecordNotFoundException;
import com.mycompany.apidesperfectos.modelo.Desperfecto;
import com.mycompany.apidesperfectos.modelo.Usuario;
import com.mycompany.apidesperfectos.servicios.DesperfectoService;
import com.mycompany.apidesperfectos.servicios.UsuarioService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Antonio Martinez Diaz
 */
@RestController
@RequestMapping("/desperfecto")
public class DesperfectoControlador
{
    @Autowired
    DesperfectoService service;
    
    @Autowired
    UsuarioService usuarioservicio;
 
    @GetMapping
    public ResponseEntity<List<Desperfecto>> getAllDesperfectos() {
        List<Desperfecto> list = service.getAllDesperfectos();
 
        return new ResponseEntity<List<Desperfecto>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Desperfecto> getDesperfectoById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
    	Desperfecto entity = service.getDesperfectoById(id);
 
        return new ResponseEntity<Desperfecto>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    
    /*@GetMapping("/search/{title}")
    public ResponseEntity<List<Desperfecto>> getDesperfectosByTitle(@PathVariable("title") String title) {
    	List<Desperfecto> list = service.getDesperfectosByTitle(title);
 
        return new ResponseEntity<List<Desperfecto>>(list, new HttpHeaders(), HttpStatus.OK);
    }*/
 

    
    @PutMapping
    public ResponseEntity<Desperfecto> UpdateDesperfecto(@Valid @RequestBody Desperfecto myDesperfecto)
                                                   throws RecordNotFoundException {
        Desperfecto updated = service.UpdateDesperfecto(myDesperfecto);
        return new ResponseEntity<Desperfecto>(updated, new HttpHeaders(), HttpStatus.OK);
     }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteDesperfectoById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteDesperfectoById(id);
        return HttpStatus.ACCEPTED;
    }
    
    
    @PostMapping("/nuevoDesperfecto/{id_usuario}")
     public ResponseEntity<Desperfecto> createIngeniero(@PathVariable("id_usuario") Long id_usuario, @Valid @RequestBody Desperfecto desperfecto) {
        Desperfecto created = service.createDesperfecto(id_usuario, desperfecto);
        return new ResponseEntity<Desperfecto>(created, new HttpHeaders(), HttpStatus.OK);
    }
 
}
