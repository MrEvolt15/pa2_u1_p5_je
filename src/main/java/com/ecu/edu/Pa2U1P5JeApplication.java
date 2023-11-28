package com.ecu.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecu.edu.transferencia.repository.modelo.CuentaBancaria;
import com.ecu.edu.transferencia.repository.modelo.Transferencia;
import com.ecu.edu.transferencia.service.ICuentaBancariaService;
import com.ecu.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5JeApplication implements CommandLineRunner{

	
	@Autowired
	private ICuentaBancariaService bancariaService;
	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	
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

				this.iTransferenciaService.realizar( new BigDecimal(20),"1234", "5678");

				CuentaBancaria ctaOrigen1 = this.bancariaService.buscar("1234");
				System.out.println(ctaOrigen1);
				CuentaBancaria ctaDestino1 = this.bancariaService.buscar("5678");
				System.out.println(ctaDestino1);
				this.iTransferenciaService.realizar( new BigDecimal(50),"1234", "5678");
				this.iTransferenciaService.realizar( new BigDecimal(10), "5678","1234");
				
				//COnstruir un reporte del estado de cuenta
				int indice=0;
				for(Transferencia t:this.iTransferenciaService.reporte()) {
					indice++;
					System.out.println(indice +": "+t);
				}
				System.out.println(this.bancariaService.buscar("1234"));
				System.out.println(this.bancariaService.buscar("5678"));
				this.bancariaService.depositar(BigDecimal.valueOf(20), "1234");
				System.out.println(this.bancariaService.buscar("1234"));
	}

}
