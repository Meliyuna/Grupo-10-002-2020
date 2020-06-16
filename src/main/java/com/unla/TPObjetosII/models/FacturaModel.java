package com.unla.TPObjetosII.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class FacturaModel {
	 
	private int idFactura;
	
	@JsonIgnore
	private ClienteModel cliente;
	

	
	@JsonIgnore
	private CarritoModel carrito;
	
	@JsonIgnore
	private EmpleadoModel empleado;
	
	
	public FacturaModel() {
	}
	
	public FacturaModel(int idFactura,CarritoModel carrito,ClienteModel cliente,EmpleadoModel empleado) {
		super();
		this.idFactura=idFactura;
		this.carrito = carrito;
		this.cliente=cliente;
		this.empleado=empleado;
	}
	
	public FacturaModel(LocalModel local, CarritoModel carrito,ClienteModel cliente,EmpleadoModel empleado) {
		super();
		this.carrito = carrito;
		this.cliente=cliente;
		this.empleado=empleado;
	}

	public int getIdFactura() {
		return idFactura;
	}

	protected void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	

	public CarritoModel getCarrito() {
		return carrito;
	}

	public void setCarrito(CarritoModel carrito) {
		this.carrito = carrito;
	}
	
	

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	
	
	public EmpleadoModel getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoModel empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "FacturaModel [idFactura=" + idFactura + ", cliente=" + cliente + ", carrito=" + carrito + ", empleado="
				+ empleado + "]";
	}

	

	
	
	

}
