package com.productos.models.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productos.models.entity.Producto;

//@Service
public interface IProductoService {
	
	public List<Producto> findAll() ;
	
	public Producto findById(Long id) ;
}
