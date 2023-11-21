package com.ecu.edu.repository;

import java.util.List;

import com.ecu.edu.repository.modelo.Materia;

public interface IMateriaRepository {
	public Materia seleccionar(String codigo);
	public void insertar(Materia materia);
	public void actualizar(Materia materia);
	public void borrar(String codigo);
	public List<Materia> seleccionarTodas();
}
