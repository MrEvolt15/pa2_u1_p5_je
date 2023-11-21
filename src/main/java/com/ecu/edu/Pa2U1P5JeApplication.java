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
	private Materia materia;
	@Autowired
	private Materia materia1;
	@Autowired
	private Materia materia2;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.materia.setNombre("Avanzada 2");
		System.out.println(this.materia);
		
		
		System.out.println(materia1);
		this.materia1.setNombre("Nuevo nombre");
		System.out.println(materia1);
		System.out.println(materia);
		
		this.materia2.setNombre("Nombre Final");
		System.out.println(this.materia2);
		System.out.println(this.materia1);
		System.out.println(this.materia);
	}

}
