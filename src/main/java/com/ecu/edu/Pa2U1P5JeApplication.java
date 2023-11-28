package com.ecu.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecu.edu.ioc.di.Estudiante;
import com.ecu.edu.repository.modelo.Materia;
import com.ecu.edu.service.IMateriaService;
import com.ecu.edu.transferencia.repository.modelo.CuentaBancaria;
import com.ecu.edu.transferencia.service.ICuentaBancariaService;
import com.ecu.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5JeApplication implements CommandLineRunner{

	
	@Autowired
	private ITransferenciaService iTransferenciaService;
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 1. Crear las cuentas
		CuentaBancaria ctaOrigen = new CuentaBancaria();
		ctaOrigen.setCedulaPropietario("1724362106");
		ctaOrigen.setNumero("1234");
		ctaOrigen.setSaldo(new BigDecimal(100));
		this.bancariaService.guardar(ctaOrigen);

		CuentaBancaria ctaDestino = new CuentaBancaria();
		ctaDestino.setCedulaPropietario("1724362114");
		ctaDestino.setNumero("5678");
		ctaDestino.setSaldo(new BigDecimal(200));
		this.bancariaService.guardar(ctaDestino);
		CuentaBancaria ctaOrigen1 = this.bancariaService.buscar("1234");
		System.out.println(ctaOrigen1);
		
		CuentaBancaria ctaDestino1 = this.bancariaService.buscar("5678");
		System.out.println(ctaDestino1);

		this.iTransferenciaService.realizar(BigDecimal.valueOf(20),"1234", "5678");

		CuentaBancaria ctaOrigen2 = this.bancariaService.buscar("1234");
		System.out.println(ctaOrigen2);
		
		CuentaBancaria ctaDestino2 = this.bancariaService.buscar("5678");
		System.out.println(ctaDestino2);
		this.iTransferenciaService.realizar(BigDecimal.valueOf(50),"1234", "5678");
		this.iTransferenciaService.realizar(BigDecimal.valueOf(30), "5678","1234");
		
	}

}
