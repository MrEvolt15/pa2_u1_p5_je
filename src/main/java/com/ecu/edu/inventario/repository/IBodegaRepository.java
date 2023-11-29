package com.ecu.edu.inventario.repository;

import com.ecu.edu.inventario.repository.modelo.Bodega;

public interface IBodegaRepository {
	public Bodega seleccionar(String codigo);

	public void insertar(Bodega bodega);

	public void actualizar(Bodega bodega);

	public void eliminar(String codigo);
}
