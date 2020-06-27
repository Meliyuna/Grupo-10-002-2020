package com.unla.TPObjetosII.models;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class FacturaModel {
	 
	private int idFactura;
	
	@JsonIgnore
	private ClienteModel cliente;
	

	
	@JsonIgnore
	private CarritoModel carrito;
	
	@JsonIgnore
	private EmpleadoModel empleado;
	
	
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy' 'HH:mm:ss")
	private LocalDateTime fechaFacturado;
	
	public FacturaModel() {
	}
	
	public FacturaModel(int idFactura,CarritoModel carrito,ClienteModel cliente,EmpleadoModel empleado,LocalDateTime fecha) {
		super();
		this.idFactura=idFactura;
		this.carrito = carrito;
		this.cliente=cliente;
		this.empleado=empleado;
		this.setFechaFacturado(fecha);
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

	public LocalDateTime getFechaFacturado() {
		return fechaFacturado;
	}

	public void setFechaFacturado(LocalDateTime fechaFacturado) {
		this.fechaFacturado = fechaFacturado;
	}

	@Override
	public String toString() {
		return "FacturaModel [idFactura=" + idFactura + ", cliente=" + cliente + ", carrito=" + carrito + ", empleado="
				+ empleado + ", fechaFacturado=" + fechaFacturado + "]";
	}

	

	

	
	
	

}
