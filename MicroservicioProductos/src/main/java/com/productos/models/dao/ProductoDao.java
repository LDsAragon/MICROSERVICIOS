package com.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.productos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> {

	
	
}
