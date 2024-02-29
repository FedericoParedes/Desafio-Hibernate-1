package com.paredesfederico.services;

import java.util.List;

import com.paredesfederico.entidades.Persona;

public interface IPersonaService {

	public Persona guardarPersona (Persona persona);
	
	public List<Persona> obtenerPersonas();
	
	public Persona obtenerPersonaPorId (Integer idPersona);
	
	public void eliminarPersona (Integer idPersona);
	
	
}
