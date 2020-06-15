package com.unla.TPObjetosII.entities;

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
	
	public Factura(){
		
	}
	
	public Factura(int idFactura, Carrito carrito,Cliente cliente) {
		super();
		this.idFactura=idFactura;
		this.carrito = carrito;
		this.cliente=cliente;
	}
	
	public Factura(Carrito carrito,Cliente cliente) {
		super();
		this.carrito = carrito;
		this.cliente=cliente;
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

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", carrito=" + carrito + ", cliente=" + cliente + "]";
	}

	
	
	

}
