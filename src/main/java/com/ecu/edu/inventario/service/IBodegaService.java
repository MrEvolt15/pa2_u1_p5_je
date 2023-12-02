package com.ecu.edu.inventario.service;

import com.ecu.edu.inventario.repository.modelo.Bodega;

public interface IBodegaService {
	public Bodega buscar(String codigo);

	public void guardar(Bodega bodega);

	public void actualizar(Bodega bodega);

	public void borrar(String codigo);
}
