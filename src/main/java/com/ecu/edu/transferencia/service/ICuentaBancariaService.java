package com.ecu.edu.transferencia.service;

import com.ecu.edu.transferencia.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	public CuentaBancaria buscar(String numero);
	public void guardar(CuentaBancaria cuenta);
	public void actualizar(CuentaBancaria cuenta);
	public void borrar(String numero);
}
