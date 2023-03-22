package com.servicio.productos.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.servicio.productos.models.entity.Producto;
import com.servicio.productos.models.service.IProductoService;

@RestController //Convierte a JSON los datos pasados por el handler (response body), indica api rest
public class ProductoController {

	@Autowired
	private Environment env;

	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/listar") // Anotacion que permite mappear la dirección url
	public List<Producto> listar(){  //Este metodo es un handler
		// List<Producto> list = new ArrayList<>();
		// list.add(new Producto());
		// if (productoService.findAll().size() == 0) {
		// 	return list;
		// };
		return  productoService.findAll().stream().map(p -> {
			p.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return p;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return producto;
	}
}
