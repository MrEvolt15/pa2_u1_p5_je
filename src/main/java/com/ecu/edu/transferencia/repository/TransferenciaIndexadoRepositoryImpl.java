package com.ecu.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecu.edu.transferencia.repository.modelo.TransferenciaIndexado;

@Repository
public class TransferenciaIndexadoRepositoryImpl implements ITransferenciaIndexadoRepository{
    
    private static List<TransferenciaIndexado> baseIndex = new ArrayList<>();
   
    public TransferenciaIndexadoRepositoryImpl(){
        TransferenciaIndexado ti = new TransferenciaIndexado();
        baseIndex.add(ti);
    }
    
    @Override
    public TransferenciaIndexado seleccionar(String numero) {
        for(TransferenciaIndexado ti:baseIndex){
			if(ti.getNumero().equals(numero)) return ti;

		}
		return null;
    }

    @Override
    public void insertar(TransferenciaIndexado transferencia) {
        
        baseIndex.add(transferencia);
    }

    @Override
    public void actualizar(TransferenciaIndexado transferencia) {
        this.eliminar(transferencia.getNumero());
		this.insertar(transferencia);
    }

    @Override
    public void eliminar(String numero) {
        baseIndex.remove(this.seleccionar(numero));
    }

    @Override
    public List<TransferenciaIndexado> selecTodo() {
        return baseIndex;
    }
    
}
