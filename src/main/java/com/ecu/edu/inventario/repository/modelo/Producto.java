package com.ecu.edu.inventario.repository.modelo;

import org.springframework.stereotype.Component;

@Component
public class Producto {
	
	private String nombre;
	private Integer stock;
	private String codBarras;
	
	//SETS Y GETS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", stock=" + stock + ", codBarras=" + codBarras + "]";
	}
	
	
}
