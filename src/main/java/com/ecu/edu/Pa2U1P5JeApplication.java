package com.ecu.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecu.edu.inventario.repository.modelo.Bodega;
import com.ecu.edu.inventario.repository.modelo.Inventario;
import com.ecu.edu.inventario.repository.modelo.Producto;
import com.ecu.edu.inventario.service.IBodegaService;
import com.ecu.edu.inventario.service.IInventarioService;
import com.ecu.edu.inventario.service.IProductoService;

@SpringBootApplication
public class Pa2U1P5JeApplication implements CommandLineRunner{
	
	@Autowired
	private IProductoService iProductoService;
	@Autowired
	private IBodegaService bodegaService;
	@Autowired
	private IInventarioService iInventarioService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Producto p = new Producto();
		p.setCodBarras("2154sdf");
		p.setNombre("HP 15 lap");
		p.setStock(0);
		
		this.iProductoService.guardar(p);
		Producto p2 = new Producto();
		p2.setCodBarras("11446");
		p2.setNombre("Teclado HP");
		p2.setStock(0);
		this.iProductoService.guardar(p2);
		
		Bodega b = new Bodega();
		b.setCapacidad(15000);
		b.setCodigo("78546521");
		b.setDireccion("Mena Dos");
		b.setNombre("Super Mena Dos");
		this.bodegaService.guardar(b);
		System.out.println(p);
		System.out.println(p2);
		System.out.println(b);
		
		this.iInventarioService.registrar("2154sdf", "78546521", 50);
		this.iInventarioService.registrar("11446", "78546521", 100);
		this.iInventarioService.registrar("2154sdf", "78546521", 20);

		for(Inventario i : this.iInventarioService.reporte()){
			System.out.println(i);
		}
		

	}

	

}
