package com.ecu.edu.inventario.repository;

import com.ecu.edu.inventario.repository.modelo.Producto;

public interface IProductoRepository {
	public Producto seleccionar(String codBarras);

	public void insertar(Producto producto);

	public void actualizar(Producto producto);

	public void eliminar(String codBarras);
}
