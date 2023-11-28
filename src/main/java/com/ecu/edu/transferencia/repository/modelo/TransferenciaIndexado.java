package com.ecu.edu.transferencia.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class TransferenciaIndexado {
	
	private Integer index=0;
	private String numero;
	private LocalDateTime fecha;
	private BigDecimal monto;
	private CuentaBancaria origen;
	private CuentaBancaria destino;
	
	//SETS Y GETS
	
	public LocalDateTime getFecha() {
		return fecha;
	}
	public CuentaBancaria getDestino() {
		return destino;
	}
	public void setDestino(CuentaBancaria destino) {
		this.destino = destino;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public CuentaBancaria getOrigen() {
		return origen;
	}
	public void setOrigen(CuentaBancaria origen) {
		this.origen = origen;
	}
	
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	@Override
	public String toString() {
		return "TransferenciaIndexado [index=" + index + ", numero=" + numero + ", fecha=" + fecha + ", monto=" + monto
				+ ", origen=" + origen + ", destino=" + destino + "]";
	}
}
