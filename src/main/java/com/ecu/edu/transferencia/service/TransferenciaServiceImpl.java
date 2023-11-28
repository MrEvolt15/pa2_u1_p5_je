package com.ecu.edu.transferencia.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecu.edu.transferencia.repository.ICuentaBancariaRepository;
import com.ecu.edu.transferencia.repository.ITransferenciaRepository;
import com.ecu.edu.transferencia.repository.modelo.CuentaBancaria;
import com.ecu.edu.transferencia.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {
	
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	public Transferencia buscar(String numero) {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionar(numero);
	}

	public void guardar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.insertar(transferencia);
	}

	public void actualizar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.actualizar(transferencia);
	}

	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.iTransferenciaRepository.eliminar(numero);
	}



	@Override
	public void realizar(BigDecimal monto, String numOrigen, String numDestino) {
		// TODO Auto-generated method stub
		//1.Buscar Cta Origen
		CuentaBancaria cO =this.bancariaRepository.seleccionar(numOrigen);
		//2. Consultar el saldo
		//3. Validar el saldo
		//4.Restar el monto
		//5. Actualizar la Cta Origen
		if(cO.getSaldo().compareTo(monto)==0||cO.getSaldo().compareTo(monto)==1){
			cO.setSaldo(cO.getSaldo().subtract(monto));
			this.bancariaRepository.actualizar(cO);
			//6. Buscar Ca Destino
			CuentaBancaria cD = this.bancariaRepository.seleccionar(numDestino);
			//7. Consultar el saldo
			//8. Sumar el monto
			//9. Actualizar Cta Destino
			cD.setSaldo(cD.getSaldo().add(monto));
			this.bancariaRepository.actualizar(cD);
			//10. Crear la transferencia
			Transferencia transferencia = new Transferencia();
			transferencia.setFecha(LocalDateTime.now());
			transferencia.setMonto(monto);
			transferencia.setNumero("00022");
			transferencia.setOrigen(cO);
			transferencia.setDestino(cD);
		
			this.iTransferenciaRepository.insertar(transferencia);
			System.out.println("Transferenia realizada con exito !!");
			
		}else {
			System.out.println("Saldo insuficiente!!");
		}
		
	}

}
