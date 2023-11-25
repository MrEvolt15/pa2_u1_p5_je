package com.ecu.edu.transferencia.service;

import java.math.BigDecimal;

import com.ecu.edu.transferencia.repository.modelo.Transferencia;

public interface ITransferenciaService {
	public Transferencia buscar(String numero);
	public void guardar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public void borrar(String numero);
	public void realizar(BigDecimal monto,String numOrigen, String numDestino);//la capa service debe recibir los datos minimos necesarios
	
}
