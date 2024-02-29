package com.paredesfederico.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paredesfederico.dao.ITelefonoRepository;
import com.paredesfederico.entidades.Telefono;
import com.paredesfederico.services.ITelefonoService;

@Service
public class TelefonoServicesImpl implements ITelefonoService {
	
	@Autowired
	private ITelefonoRepository telefonoRepository;

	@Override
	public Telefono guardarTelefono(Telefono telefono) {
		Telefono telefonoGuardado = telefonoRepository.save(telefono);
		return telefonoGuardado;
	}

	@Override
	public List<Telefono> obtenerTodos() {
		
				
		return telefonoRepository.findAll();
	}

	@Override
	public Telefono obtenerTelefonoPorId(Integer idTelefono) {
		
		
		return telefonoRepository.findById(idTelefono).orElse(null);
	}

	@Override
	public void eliminarTelefono(Integer idTelefono) {

		telefonoRepository.deleteById(idTelefono);
		
	}

	
	
	
}
