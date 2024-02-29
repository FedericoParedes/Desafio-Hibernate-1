package com.paredesfederico.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paredesfederico.entidades.Persona;

public interface IPersonaRepository extends JpaRepository<Persona, Integer>{

	
	
}
