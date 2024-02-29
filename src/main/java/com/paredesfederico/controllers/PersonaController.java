package com.paredesfederico.controllers;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.paredesfederico.entidades.Persona;
import com.paredesfederico.entidades.Telefono;
import com.paredesfederico.services.IPersonaService;
import com.paredesfederico.services.ITelefonoService;

@RestController
@RequestMapping(value = "/api/clientes")
public class PersonaController {

	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private ITelefonoService telefonoService;
	
	
	@PostMapping("/guardar")
	public ResponseEntity<Persona> guardarPersona (@RequestBody Persona persona) {	
				
		Persona personaAGuardar = new Persona();
		
		personaAGuardar.setNombre(persona.getNombre());
		
		personaAGuardar.setApellido(persona.getApellido());
			
	    Telefono telefonoAGuardar = new Telefono();
	    
	    telefonoAGuardar.setNumero(persona.getTelefono().getNumero());
	    
	    telefonoAGuardar.setEmpresa(persona.getTelefono().getEmpresa());
	    
	    telefonoAGuardar.setUsuario(personaAGuardar);
	    
	    personaAGuardar.setTelefono(telefonoAGuardar);
	        
	    personaService.guardarPersona(personaAGuardar);
		
		return new ResponseEntity<>(personaAGuardar,HttpStatus.CREATED);
		
	}
	
	
	
	
	@GetMapping("/listar")
	   public List<Persona> obtenerProductos(){
		  
		return personaService.obtenerPersonas();
	   }
	
	
	
	@GetMapping("/obtener/{id}")
	   public ResponseEntity<Persona> obtenerPorId(@PathVariable Integer id){
		  Persona personaBuscada = personaService.obtenerPersonaPorId(id);
		  return ResponseEntity.ok(personaBuscada);
		   
	   }
	
	
	 @PutMapping("/actualizar/{id}")
	  public ResponseEntity<Persona> actualizarPersona (@PathVariable Integer id, @RequestBody Persona persona){
		  
		 Persona personaPorActualizar = personaService.obtenerPersonaPorId(id);
		 
		 Telefono telefonoPorActualizar = telefonoService.obtenerTelefonoPorId(id);
		 
		 telefonoPorActualizar.setNumero(persona.getTelefono().getNumero());
		 
		 telefonoPorActualizar.setEmpresa(persona.getTelefono().getEmpresa());
		 
		 personaPorActualizar.setNombre(persona.getNombre());
		 
		 personaPorActualizar.setApellido(persona.getApellido());
		 
		 telefonoPorActualizar.setUsuario(personaPorActualizar);

		 personaPorActualizar.setTelefono(telefonoPorActualizar);
		 
		 Persona personaActualizada = personaService.guardarPersona(personaPorActualizar);

		 
		 return new ResponseEntity<>(personaActualizada, HttpStatus.ACCEPTED);
		  
		  
	  }
	 
	 @DeleteMapping("/eliminar/{id}")
	 public ResponseEntity<HashMap<String, Boolean>> eliminarPersona (@PathVariable Integer id){
		 
		 personaService.eliminarPersona(id);
		 
		 HashMap<String, Boolean> estadoPersonaEliminada = new HashMap<>();
		 
		 estadoPersonaEliminada.put("eliminado", true);
		 
		 return ResponseEntity.ok(estadoPersonaEliminada); 
		 
		 
	 }

	
	
	
	
	
	
	
	
	
	
	
}
