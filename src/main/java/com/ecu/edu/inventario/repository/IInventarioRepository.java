package com.ecu.edu.inventario.repository;

import java.util.List;

import com.ecu.edu.inventario.repository.modelo.Inventario;

public interface IInventarioRepository {
	public Inventario seleccionar(String codigo);

	public void insertar(Inventario inventario);

	public void actualizar(Inventario inventario);

	public void eliminar(String codigo);
	
	public List<Inventario> selecTodo();
}
