package com.ecu.edu.transferencia.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecu.edu.transferencia.repository.ICuentaBancariaRepository;
import com.ecu.edu.transferencia.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	public CuentaBancaria buscar(String numero) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionar(numero);
	}

	
	public void guardar(CuentaBancaria cuenta) {
		// TODO Auto-generated method stub
		this.bancariaRepository.insertar(cuenta);
	}

	
	public void actualizar(CuentaBancaria cuenta) {
		// TODO Auto-generated method stub
		this.bancariaRepository.actualizar(cuenta);
	}

	
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.bancariaRepository.eliminar(numero);
	}


	@Override
	public void depositar(BigDecimal monto,String destino) {
		CuentaBancaria cta = this.bancariaRepository.seleccionar(destino);
		
		BigDecimal restante = monto.multiply(BigDecimal.valueOf(.9));
		cta.setSaldo(cta.getSaldo().add(restante));
		
		this.actualizar(cta);
		System.out.println("Monto añadido con exito !!!");
	}

}
