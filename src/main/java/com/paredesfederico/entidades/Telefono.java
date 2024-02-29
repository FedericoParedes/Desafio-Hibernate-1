package com.paredesfederico.entidades;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "telefonos")
public class Telefono {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tel_id")
	public Integer id;
	
	@Column(name = "tel_numero")
	public Integer numero;
	
	@Column(name = "tel_empresa")
	public String empresa;
	
	@JoinColumn(name = "tel_usuario")
	@OneToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties("telefono")
	public Persona usuario;
	
	public Telefono() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Telefono(Integer numero, String empresa, Persona usuario) {
		this.numero = numero;
		this.empresa = empresa;
		this.usuario = usuario;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Persona getUsuario() {
		return usuario;
	}

	public void setUsuario(Persona usuario) {
		this.usuario = usuario;
	}
	
	
	
}
