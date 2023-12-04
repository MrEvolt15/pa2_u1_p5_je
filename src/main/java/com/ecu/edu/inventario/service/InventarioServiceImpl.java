package com.ecu.edu.inventario.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecu.edu.inventario.repository.IBodegaRepository;
import com.ecu.edu.inventario.repository.IInventarioRepository;
import com.ecu.edu.inventario.repository.IProductoRepository;
import com.ecu.edu.inventario.repository.modelo.Bodega;
import com.ecu.edu.inventario.repository.modelo.Inventario;
import com.ecu.edu.inventario.repository.modelo.Producto;

@Service
public class InventarioServiceImpl implements IInventarioService{
	@Autowired
	private IInventarioRepository iInventarioRepository;
	@Autowired
	private IProductoRepository iProductoRepository;
	@Autowired
	private IBodegaRepository bodegaRepository;

	@Override
	public Inventario buscar(String codigo) {
		// TODO Auto-generated method stub
		return this.iInventarioRepository.seleccionar(codigo);
	}

	@Override
	public void guardar(Inventario inventario) {
		// TODO Auto-generated method stub
		this.iInventarioRepository.insertar(inventario);
	}

	@Override
	public void actualizar(Inventario inventario) {
		// TODO Auto-generated method stub
		this.iInventarioRepository.actualizar(inventario);
	}

	@Override
	public void borrar(String codigo) {
		// TODO Auto-generated method stub
		this.iInventarioRepository.eliminar(codigo);
	}

	public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

	@Override
	public void registrar(String codBarras, String codBodega, Integer stock) {
		Bodega b = this.bodegaRepository.seleccionar(codBodega);
		
		Producto p = this.iProductoRepository.seleccionar(codBarras);
		p.setStock(p.getStock()+stock);
		this.iProductoRepository.actualizar(p);
		
		Inventario i = new Inventario();
		i.setBodega(b);
		Integer codigo = InventarioServiceImpl.getRandomInteger(100, 1000);
		i.setCodigo(codigo.toString());
		i.setFechaIngreso(LocalDateTime.now());
		i.setProducto(p);
		
		this.iInventarioRepository.insertar(i);
				
	}

	@Override
	public List<Inventario> reporte() {
		// TODO Auto-generated method stub
		return this.iInventarioRepository.selecTodo();
	}
	
}
