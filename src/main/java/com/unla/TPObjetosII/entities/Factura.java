package com.unla.TPObjetosII.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="factura")
public class Factura {
	@Id
	@GeneratedValue
	@Column(name="idFactura")
	private int idFactura;
	private Local local;
	private Carrito carrito;
	
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
