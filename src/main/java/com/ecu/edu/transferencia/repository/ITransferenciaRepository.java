package com.ecu.edu.transferencia.repository;

import com.ecu.edu.transferencia.repository.modelo.Transferencia;

public interface ITransferenciaRepository {
	public Transferencia seleccionar(String numero);
	public void insertar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
	public void eliminar(String numero);
}
