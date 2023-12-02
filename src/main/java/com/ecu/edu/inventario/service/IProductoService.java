package com.ecu.edu.inventario.service;

import com.ecu.edu.inventario.repository.modelo.Producto;

public interface IProductoService {
	public Producto buscar(String codBarras);

	public void guardar(Producto producto);

	public void actualizar(Producto producto);

	public void borrar(String codBarras);
}
