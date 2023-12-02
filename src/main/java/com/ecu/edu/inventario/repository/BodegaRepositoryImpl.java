package com.ecu.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecu.edu.inventario.repository.modelo.Bodega;

@Repository
public class BodegaRepositoryImpl implements IBodegaRepository {
	private static List<Bodega> base = new ArrayList<>();
	@Override
	public Bodega seleccionar(String codigo) {
		for (Bodega b : base) {
			if (b.getCodigo()== codigo) {
				Bodega bod = new Bodega();
				bod.setCapacidad(b.getCapacidad());
				bod.setDireccion(b.getDireccion());
				bod.setNombre(b.getNombre());
				return bod;
			}
		}
		return null;
	}
	public Bodega seleccionarEliminar(String numero) {
		for (Bodega bod : base) {
			if (bod.getCodigo().equals(numero)) {	
				return bod;
			}
		}

		return null;
	}
	@Override
	public void insertar(Bodega bodega) {
		// TODO Auto-generated method stub
		base.add(bodega);
	}

	@Override
	public void actualizar(Bodega bodega) {
		// TODO Auto-generated method stub
		this.eliminar(bodega.getCodigo());
		this.insertar(bodega);
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		Bodega bod = this.seleccionarEliminar(codigo);
		base.remove(bod);
	}

}
