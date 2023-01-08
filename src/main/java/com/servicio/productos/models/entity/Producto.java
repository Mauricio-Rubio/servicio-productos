package com.servicio.productos.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="productos")
@Setter
@Getter
public class Producto implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private Double precio;
	@Column(name ="create_at")
	@Temporal(TemporalType.DATE) // Configurar como se va a guardar la fecha
	private Date createAt;
	private static final long serialVersionUID = -9121884191000533857L; //Identificador al array de bytes
}
