package com.productos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.productos.models.entity.Producto;
import com.productos.models.service.IProductoService;

@RestController
public class ProductoController {

	@Autowired
	private Environment env;
	
	@Autowired
	private IProductoService productoService ; 
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.findAll().stream().map(producto -> {
			producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) throws Exception{
		Producto producto = productoService.findById(id);  
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));

	/* Excepcion creada porque puedo para invocar un Mate Demoniaco */
//		if (true) {
//			throw new Exception("it's a deal then");
//		}
		
		
	/* Excepcion creacion de un timeout */
//		try {
//			Thread.sleep(3000L) ; 
//		} catch (Exception e) {
//			e.printStackTrace() ; 
//		}
		
		
		return producto ; 
	}
	
}
