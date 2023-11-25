package com.ecu.edu.transferencia.repository;

import com.ecu.edu.transferencia.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {
	public CuentaBancaria seleccionar(String numero);
	public void insertar(CuentaBancaria cuenta);
	public void actualizar(CuentaBancaria cuenta);
	public void eliminar(String numero);
	
}
