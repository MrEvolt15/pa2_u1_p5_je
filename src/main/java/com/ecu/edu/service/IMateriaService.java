package com.ecu.edu.service;

import java.util.List;

import com.ecu.edu.repository.modelo.Materia;

public interface IMateriaService {

	public Materia buscar(String codigo);
	public void guardar(Materia materia);
	public void actualizar(Materia materia);
	public void eliminar(String codigo);
	public List<Materia> reporte();
}
