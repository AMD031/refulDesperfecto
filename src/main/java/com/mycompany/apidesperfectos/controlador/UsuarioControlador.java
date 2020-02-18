/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apidesperfectos.controlador;

import com.mycompany.apidesperfectos.excepcion.RecordNotFoundException;
import com.mycompany.apidesperfectos.intefaces.IDesperfecto;

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
@RequestMapping("/usuario")
public class UsuarioControlador
{
    @Autowired
   UsuarioService service;
    
    @Autowired
    DesperfectoService desperfectoservice;
 
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> list = service.getAllUsuarios();
 
        return new ResponseEntity<List<Usuario>>(list, new HttpHeaders(), HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
    	Usuario entity = service.getUsuarioById(id);
 
        return new ResponseEntity<Usuario>(entity, new HttpHeaders(), HttpStatus.OK);
    }
    

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@Valid @RequestBody Usuario myUsuario){
    	Usuario created = service.createUsuario(myUsuario);
        return new ResponseEntity<Usuario>(created, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<Usuario> UpdateUsuario(@Valid @RequestBody Usuario myUsuario)
                                                    throws RecordNotFoundException {
    	Usuario updated = service.createUsuario(myUsuario);
        return new ResponseEntity<Usuario>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteUsuarioById(@PathVariable("id") Long id)
                                                    throws RecordNotFoundException {
        service.deleteUsuarioById(id);
        return HttpStatus.ACCEPTED;
    }
 
    @GetMapping("/desperfectoPorIdUsuario/{id}")
    public ResponseEntity<List<IDesperfecto>> getDesperfectosByIdUsuario(@PathVariable("id") Long id) {
    	List<IDesperfecto> list = service.getDesperfectoByIdUsuario(id);
        return new ResponseEntity<List<IDesperfecto>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
    
     @GetMapping("/desperfectoPorEmailUsuario/{email}")
     public ResponseEntity<List<IDesperfecto>> getDesperfectosByEmail(
             @PathVariable("email") String email
     ) {
    	List<IDesperfecto> list = service.getDesperfectoByEmail(email);
        return new ResponseEntity<List<IDesperfecto>>(list, new HttpHeaders(), HttpStatus.OK);
       }
     
     
     @GetMapping("/desperfectoPorNombreUsuario/{nombre}")
     public ResponseEntity<List<IDesperfecto>> getDesperfectosByNombre(
             @PathVariable("nombre") String nombre
     ) {
    	List<IDesperfecto> list = service.getDesperfectoByNombreUsuario(nombre);
        return new ResponseEntity<List<IDesperfecto>>(list, new HttpHeaders(), HttpStatus.OK);
       }
    
    
    
    
    
    
}
