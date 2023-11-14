package com.ecu.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecu.edu.ioc.di.Estudiante;

@SpringBootApplication
public class Pa2U1P5JeApplication implements CommandLineRunner{

	@Autowired  //Con esta anotacion hago la inyeccion de dependencias
	private Estudiante estudiante;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.estudiante.setNombre("Joel");
		this.estudiante.setApellido("Espinosa");
		this.estudiante.setCedula("1726333196");
		this.estudiante.setSalario(BigDecimal.valueOf(0));
		System.out.println(estudiante);
	}

}
