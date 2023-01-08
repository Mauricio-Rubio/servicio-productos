package com.servicio.productos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servicio.productos.models.dao.ProductoDao;
import com.servicio.productos.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{
	@Autowired 
	private ProductoDao productoDao; //Inyección del elemento en runtime
	
	@Override
	@Transactional(readOnly = true) //Facilita el uso de transacciones en spring boot
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true) // Unicamente aplica lectura
	public Producto findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

}
