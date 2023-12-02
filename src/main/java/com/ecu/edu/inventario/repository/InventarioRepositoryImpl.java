package com.ecu.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecu.edu.inventario.repository.modelo.Inventario;

@Repository
public class InventarioRepositoryImpl implements IInventarioRepository {
	private static List<Inventario> base = new ArrayList<>();
	@Override
	public Inventario seleccionar(String codigo) {
		for (Inventario i : base) {
			if (i.getCodigo()== codigo) {
				Inventario inven = new Inventario();
				inven.setBodega(i.getBodega());
				inven.setFechaIngreso(i.getFechaIngreso());
				inven.setProducto(i.getProducto());
				
				return inven;
			}
		}
		return null;
	}
	
	public Inventario seleccionarEliminar(String numero) {
		for (Inventario inv : base) {
			if (inv.getCodigo().equals(numero)) {	
				return inv;
			}
		}

		return null;
	}

	@Override
	public void insertar(Inventario inventario) {
		// TODO Auto-generated method stub
		base.add(inventario);
	}

	@Override
	public void actualizar(Inventario inventario) {
		// TODO Auto-generated method stub
		this.eliminar(inventario.getCodigo());
		this.insertar(inventario);
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		Inventario inv = this.seleccionarEliminar(codigo);
		base.remove(inv);
	}

}
