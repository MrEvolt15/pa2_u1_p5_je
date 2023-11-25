package com.ecu.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecu.edu.transferencia.repository.modelo.CuentaBancaria;

@Repository
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository{
	
	private static List<CuentaBancaria> base = new ArrayList<>();
	@Override
	public CuentaBancaria seleccionar(String numero) {
		for(CuentaBancaria c : base) {
			if(c.getNumero().equals(numero)){
				return c;
			}
		}
		
		return null;
	}

	@Override
	public void insertar(CuentaBancaria cuenta) {
		base.add(cuenta);
		
	}

	@Override
	public void actualizar(CuentaBancaria cuenta) {
		this.eliminar(cuenta.getNumero());
		this.insertar(cuenta);
		
	}

	@Override
	public void eliminar(String numero) {
		base.remove(this.seleccionar(numero));
		
	}

}
