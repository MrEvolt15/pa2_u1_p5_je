package com.ecu.edu.repository.modelo;

import org.springframework.stereotype.Component;

@Component
public class Materia {
	private String nombre;
	private String codigo;
	private Integer numCreditos;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getNumCreditos() {
		return numCreditos;
	}
	public void setNumCreditos(Integer numCreditos) {
		this.numCreditos = numCreditos;
	}
	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", codigo=" + codigo + ", numCreditos=" + numCreditos + "]";
	}
	
}
