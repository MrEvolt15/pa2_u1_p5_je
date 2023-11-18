package com.ecu.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecu.edu.repository.IMateriaRepository;
import com.ecu.edu.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService{
	
	@Autowired
	private IMateriaRepository iMateriaRepository;

	@Override
	public Materia buscar(String codigo) {
		
		return this.iMateriaRepository.seleccionar(codigo);
	}

	@Override
	public void guardar(Materia materia) {
		this.iMateriaRepository.insertar(materia);
		
	}

	@Override
	public void actualizar(Materia materia) {
		this.iMateriaRepository.actualizar(materia);
	}

	@Override
	public void eliminar(String codigo) {
		this.iMateriaRepository.borrar(codigo);
	}

	@Override
	public List<Materia> reporte() {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.seleccionarTodas();
	}

}
