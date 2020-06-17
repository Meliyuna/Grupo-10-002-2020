package com.unla.TPObjetosII.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unla.TPObjetosII.models.ClienteModel;

@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDFACTURA")
	private int idFactura;
	
	
	@JsonIgnore
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDCARRITO")
	private Carrito carrito;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDCLIENTE")
	private Cliente cliente;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDEMPLEADOFACTURA")
	private Empleado empleado;
	
	@Column(name="FECHAFACTURADO")
	private LocalDateTime fechaFacturado;
	
	public Factura(){
		
	}
	
	public Factura(int idFactura, Carrito carrito,Cliente cliente,Empleado empleado,LocalDateTime fecha) {
		super();
		this.idFactura=idFactura;
		this.carrito = carrito;
		this.cliente=cliente;
		this.empleado=empleado;
		this.fechaFacturado=fecha;
	}
	
	public Factura(Carrito carrito,Cliente cliente,Empleado empleado,LocalDateTime fecha) {
		super();
		this.carrito = carrito;
		this.cliente=cliente;
		this.empleado=empleado;
		this.fechaFacturado=fecha;
	}


	public int getIdFactura() {
		return idFactura;
	}

	protected void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}



	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
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
		return "Factura [idFactura=" + idFactura + ", carrito=" + carrito + ", cliente=" + cliente + ", empleado="
				+ empleado + ", fechaFacturado=" + fechaFacturado + "]";
	}

	

	

	
	
	

}
