package com.paredesfederico.services;

import java.util.List;

import com.paredesfederico.entidades.Telefono;

public interface ITelefonoService {

	public Telefono guardarTelefono (Telefono telefono);
	
	public List<Telefono> obtenerTodos ();
	
	public Telefono obtenerTelefonoPorId (Integer idTelefono);
	
	public void eliminarTelefono (Integer idTelefono);
	
	
	
	
	
	
}
