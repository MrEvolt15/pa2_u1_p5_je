package com.ecu.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecu.edu.inventario.repository.modelo.Producto;

@Repository
public class ProductoRepositoryImpl implements IProductoRepository {
	private static List<Producto> base = new ArrayList<>();
	@Override
	public Producto seleccionar(String codBarras) {
		for (Producto p : base) {
			if (p.getCodBarras()== codBarras) {
				Producto prod = new Producto();
				prod.setNombre(p.getNombre());
				prod.setStock(p.getStock());
				return prod;
			}
		}
		return null;
	}
	public Producto seleccionarEliminar(String codBarras) {
		for (Producto prod : base) {
			if (prod.getCodBarras().equals(codBarras)) {	
				return prod;
			}
		}

		return null;
	}

	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		base.add(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.eliminar(producto.getCodBarras());
		this.insertar(producto);

	}

	@Override
	public void eliminar(String codBarras) {
		// TODO Auto-generated method stub
		Producto prod = this.seleccionarEliminar(codBarras);
		base.remove(prod);
	}

}
