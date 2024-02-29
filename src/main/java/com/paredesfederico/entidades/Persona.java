package com.paredesfederico.entidades;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "per_id")
	public Integer id;
   
    @Column(name = "per_nombre")
	public String nombre;
	
    @Column(name = "per_apellido")
	public String apellido;
	
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("usuario")
	public Telefono telefono;
	
	
	public Persona() {
	
	}
	


	public Persona(String nombre, String apellido, Telefono telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public Telefono getTelefono() {
		return telefono;
	}


	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}


	
		
	
}
