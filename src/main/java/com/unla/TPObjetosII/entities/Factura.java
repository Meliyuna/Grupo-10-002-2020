package com.unla.TPObjetosII.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Factura {

	private int idFactura;
	
	@JsonIgnore
	private Local local;
	
	@JsonIgnore
	private Carrito carrito;
	
	public Factura(){
		
	}
	
	public Factura(Local local, Carrito carrito) {
		super();
		this.local = local;
		this.carrito = carrito;
	}

	public int getIdFactura() {
		return idFactura;
	}

	protected void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Carrito getCarrito() {
		return carrito;
	}

	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", local=" + local + ", carrito=" + carrito + "]";
	}
	
	
	

}
