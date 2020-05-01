package com.unla.TPObjetosII.entities;


import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


public class Carrito {

	private int idCarrito;
	
	private Set<Pedido> listaPedido;

	private LocalDate fecha;

	private float total;
	
	private Cliente cliente;

	public Carrito() {
	}

	public Carrito(Set<Pedido> listaPedido, LocalDate fecha, float total, Cliente cliente) {
		super();
		this.listaPedido = listaPedido;
		this.fecha = fecha;
		this.total = total;
		this.cliente = cliente;
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	protected void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public Set<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(Set<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", listaPedido=" + listaPedido + ", fecha=" + fecha + ", total="
				+ total + ", cliente=" + cliente + "]";
	}

	

}
