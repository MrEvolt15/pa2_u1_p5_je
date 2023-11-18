package com.ecu.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecu.edu.ioc.di.Estudiante;
import com.ecu.edu.repository.modelo.Materia;
import com.ecu.edu.service.IMateriaService;

@SpringBootApplication
public class Pa2U1P5JeApplication implements CommandLineRunner{

	@Autowired
	private IMateriaService iMateriaService;
	
	@Autowired
	private Materia materia;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.materia.setCodigo("M1");
		this.materia.setNombre("P Avanzada");
		this.materia.setNumCreditos(10);
		this.iMateriaService.guardar(materia);
		System.out.println("Reporte Inicio");
		for(Materia m2 : this.iMateriaService.reporte()) {
			System.out.println(m2);
		}
		System.out.println("Reporte fin");
		Materia m =this.iMateriaService.buscar("M1");
		System.out.println(m);
		m.setNumCreditos(20);
		this.iMateriaService.actualizar(m);
		System.out.println(this.iMateriaService.buscar("M1"));
		
		this.iMateriaService.eliminar("M1");
		System.out.println(this.iMateriaService.buscar("M1"));
		
		
	}

}
