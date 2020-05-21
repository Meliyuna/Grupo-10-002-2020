package com.unla.TPObjetosII.models;

import java.time.LocalDate;

public class ProductoModel {
	
	private int idProducto;
	private String nombre;
	private String descripcion;
	private float precio;
	private LocalDate fechaAlta;
	private int cantidad;
	
	public ProductoModel() {}
	

	public ProductoModel(String nombre, String descripcion, float precio, LocalDate fechaAlta, int cantidad) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fechaAlta = fechaAlta;
		this.cantidad = cantidad;
	}
	
	

	public ProductoModel(int idProducto, String nombre, String descripcion, float precio, LocalDate fechaAlta,
			int cantidad) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.fechaAlta = fechaAlta;
		this.cantidad = cantidad;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ProductoModel [idProducto=" + idProducto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", fechaAlta=" + fechaAlta + ", cantidad=" + cantidad + "]";
	}
	

}
