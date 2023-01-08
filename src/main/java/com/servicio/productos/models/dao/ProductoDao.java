package com.servicio.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.servicio.productos.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{

}
