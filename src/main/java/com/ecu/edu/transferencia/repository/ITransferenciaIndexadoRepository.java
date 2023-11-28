package com.ecu.edu.transferencia.repository;


import java.util.List;

import com.ecu.edu.transferencia.repository.modelo.TransferenciaIndexado;

public interface ITransferenciaIndexadoRepository {
    public TransferenciaIndexado seleccionar(String numero);
	public void insertar(TransferenciaIndexado transferencia);
	public void actualizar(TransferenciaIndexado transferencia);
	public void eliminar(String numero);
	public List<TransferenciaIndexado> selecTodo();
}
