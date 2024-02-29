package com.paredesfederico.personas;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.paredesfederico.entidades.Persona;
import com.paredesfederico.entidades.Telefono;
import com.paredesfederico.services.IPersonaService;
import com.paredesfederico.services.ITelefonoService;

@SpringBootTest
public class TestPersona {

	@Autowired
	private IPersonaService personaService;
	
	@Autowired
	private ITelefonoService telefonoService;
	
	
	@Test
	public void guardarPersona () {
		
		System.out.println("Comienza la prueba unitaria");
		
	    List<Persona> personasAGuardar = new ArrayList<>();
		
		String[] nombres = {"Federico","Priscila","Guadalupe","Camila","Facundo","Brian","Enzo","Angeles","Tania","Jonatan",};
		
		String[] apellidos = {"Paredes","Cabrera","Lanuti","Aguero","Schulz","Ocaranza","Sanchez","Caselli","Ramirez","Rosales",};
		
		int[] telefonos = {1121846692,1135912604,1102778926,1145297855,1167014381,1179521243,1196743249,1124409852,1147802633,1195623722};

		String[] empresas = {"Personal","Movistar","Claro","Tuenti"};
		
		int contador = 0;
		
		for(int i=0;i<10;i++) {
			
	    if(contador>3) {
	    	
	    	contador = 0;
	    }
			
	    Persona personaAGuardar = new Persona();
	    
	    Telefono telefonoAGuardar = new Telefono();

       personaAGuardar.setNombre(nombres[i]);
		
		personaAGuardar.setApellido(apellidos[i]);
		
		telefonoAGuardar.setNumero(telefonos[i]);
					
	   telefonoAGuardar.setEmpresa(empresas[contador]);
							
		telefonoAGuardar.setUsuario(personaAGuardar);
				
		personaAGuardar.setTelefono(telefonoAGuardar);
		
		personasAGuardar.add(personaAGuardar);
			
		contador++;
			
		}
		       
         for(Persona p : personasAGuardar) {
        	 
        	 personaService.guardarPersona(p);
         }
	   
       System.out.println("Se guardan los registros de personas y telefonos");
			
		List<Persona> personasGuardadas = personaService.obtenerPersonas();
		
		List<Telefono> telefonosGuardados = telefonoService.obtenerTodos();
	
		System.out.println("Se comprueba que se han insertado 10 registros en ambas tablas");
		
		assertThat(personasGuardadas.size()).isEqualTo(10);
		
		assertThat(telefonosGuardados.size()).isEqualTo(10);
		
		System.out.println("Comienzan las validaciones de cada registro");
		
		for(int i=0; i<personasGuardadas.size();i++) {
			
		Persona personaGuardada = personaService.obtenerPersonaPorId(i+1);
	
		Telefono telefonoGuardado = telefonoService.obtenerTelefonoPorId(i+1);
				
        assertTrue(personaGuardada.getId().equals(telefonoGuardado.getId()));
		
		assertTrue(personaGuardada.getNombre().equals(telefonoGuardado.getUsuario().getNombre()));
		
		assertTrue(personaGuardada.getApellido().equals(telefonoGuardado.getUsuario().getApellido()));
		     				
		assertTrue(personaGuardada.getTelefono().getId().equals(telefonoGuardado.getId()));
		
		assertTrue(personaGuardada.getTelefono().getNumero().equals(telefonoGuardado.getNumero()));
		
		assertTrue(personaGuardada.getTelefono().getEmpresa().equals(telefonoGuardado.getEmpresa()));
		
       System.out.println("Finalizó la validación del registro numero " + (i+1) + " en la tabla personas");
	
		assertTrue(telefonoGuardado.getId().equals(personaGuardada.getId()));
		
		assertTrue(telefonoGuardado.getNumero().equals(personaGuardada.getTelefono().getNumero()));
		
		assertTrue(telefonoGuardado.getEmpresa().equals(personaGuardada.getTelefono().getEmpresa()));
		
        assertTrue(telefonoGuardado.getUsuario().getId().equals(personaGuardada.getId())); 	
        
        assertTrue(telefonoGuardado.getUsuario().getNombre().equals(personaGuardada.getNombre()));
        
        assertTrue(telefonoGuardado.getUsuario().getApellido().equals(personaGuardada.getApellido()));
        
	   System.out.println("Finalizó la validación del registro numero " + (i+1) + " en la tabla telefonos");
	   
		}
				
         personaService.eliminarPersona(1);
         
         System.out.println("Se ha eliminado el primer registro de personas");
	     
	     List<Persona> personasGuardadas2 = personaService.obtenerPersonas();
	     
	     List<Telefono> telefonosGuardados2 = telefonoService.obtenerTodos();
	     
	     assertThat(personasGuardadas2.size()).isEqualTo(9);
	     
	     assertThat(telefonosGuardados2.size()).isEqualTo(9);
	          
	     System.out.println("Se comprueba que ahora ambas tablas tienen 9 registros");
	     
	      

              
		
	}
	
	
	
	
}
