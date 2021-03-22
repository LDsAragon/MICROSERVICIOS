package com.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.item.models.Item;
import com.item.models.Producto;
import com.item.models.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ItemController {

	@Autowired
	@Qualifier("serviceFeign")
//	@Qualifier("serviceRestTemplate")
	private ItemService itemService ; 
	
	@GetMapping("/listar")
	public List<Item> listar(){
		return itemService.findAll() ; 
	}
	
	
	@HystrixCommand(fallbackMethod = "metodoAlternativo")
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad){
		return itemService.findById(id, cantidad) ; 
	}
	
	
	public Item metodoAlternativo (Long id, Integer Cantidad) {
	
		
		Item item = new Item();
		Producto producto = new Producto(); 
		
		item.setCantidad(Cantidad);
		producto.setId(666);
		producto.setNombre("Mate Demoniaco");
		producto.setPrecio(666.0);
		producto.setPort(666);
		
		item.setProducto(producto);
		
		return item ;
	}
	
}
