package com.ecu.edu.ioc.di;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component  // con esta anotacion estoy delegando el control de este objeto a Spring Framework
public class Estudiante {
	private String nombre;
	private String apellido;
	private String cedula; // todo numero que no sea suceptible a un calculo no debe ser Integer
	private BigDecimal salario;
	
	// SETS Y GETS
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", salario=" + salario
				+ "]";
	}
	
}
