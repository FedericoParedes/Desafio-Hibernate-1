package com.paredesfederico.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paredesfederico.dao.IPersonaRepository;
import com.paredesfederico.entidades.Persona;
import com.paredesfederico.services.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService{
	
	@Autowired
	private IPersonaRepository personaRepository;

	@Override
	public Persona guardarPersona(Persona persona) {
	   Persona personaGuardada = personaRepository.save(persona);
		return personaGuardada;
	}

	@Override
	public List<Persona> obtenerPersonas() {		
		
		return personaRepository.findAll();
	}

	
	@Override
	public Persona obtenerPersonaPorId(Integer idPersona) {
			
		return personaRepository.findById(idPersona).orElse(null);
	}

	
	@Override
	public void eliminarPersona(Integer idPersona) {
        personaRepository.deleteById(idPersona);	
	}
	

}
