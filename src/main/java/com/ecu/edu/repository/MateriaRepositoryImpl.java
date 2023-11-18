package com.ecu.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ecu.edu.repository.modelo.Materia;

@Repository
public class MateriaRepositoryImpl implements IMateriaRepository{
	
	private static List<Materia> base = new ArrayList<>();
	@Override
	public Materia seleccionar(String codigo) {
		
		for(Materia m : base) {
			if(m.getCodigo().equals(codigo)){
				return m;
			}
		}
		System.out.println("Seleccionamos: "+ codigo);
		return null;
	}

	@Override
	public void insertar(Materia materia) {
		base.add(materia);
		System.out.println("Se inserto: "+materia);		
	}

	@Override
	public void actualizar(Materia materia) {
		this.borrar(materia.getCodigo());
		this.insertar(materia);
		System.out.println("Se actualiza: "+materia);
	}

	@Override
	public void borrar(String codigo) {
		base.remove(this.seleccionar(codigo));
		System.out.println("se borra: "+ codigo);
	}

	@Override
	public List<Materia> seleccionarTodas() {
		// TODO Auto-generated method stub
		return base;
	}

}
