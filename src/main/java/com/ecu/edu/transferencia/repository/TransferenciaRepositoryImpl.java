package com.ecu.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecu.edu.transferencia.repository.modelo.Transferencia;

@Repository
public class TransferenciaRepositoryImpl implements ITransferenciaRepository{
	private static List<Transferencia> base = new ArrayList<>();
	@Override
	public Transferencia seleccionar(String numero) {
		for(Transferencia t : base) {
			if(t.getNumero().equals(numero)){
				return t;
			}
		}
		
		return null;
	}

	@Override
	public void insertar(Transferencia transferencia) {
		base.add(transferencia);
		
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.eliminar(transferencia.getNumero());
		this.insertar(transferencia);
		
	}

	@Override
	public void eliminar(String numero) {
		base.remove(this.seleccionar(numero));
		
	}

	@Override
	public List<Transferencia> seleccionarTodos() {
		
		return base;
	}

}
