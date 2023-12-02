package com.ecu.edu.inventario.service;

import com.ecu.edu.inventario.repository.modelo.Inventario;

public interface IInventarioService {
	public Inventario buscar(String codigo);

	public void guardar(Inventario inventario);

	public void actualizar(Inventario inventario);

	public void borrar(String codigo);
	
	public void registrar(String codBarras,String codBodega,Integer stock );
}
