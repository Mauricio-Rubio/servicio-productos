package com.servicio.productos.models.service;

import java.util.List;

import com.servicio.productos.models.entity.Producto;

//Esta intefaz va a servir para administrar nuestros DAO (en caso de que haya varios)
public interface IProductoService {
	public List<Producto> findAll();
	public Producto findById(Long id);
}
