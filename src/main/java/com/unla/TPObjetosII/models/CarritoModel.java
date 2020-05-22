package com.unla.TPObjetosII.models;


import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CarritoModel {

	private int idCarrito;
	
	@JsonIgnore
	private Set<PedidoModel> listaPedido;
	private LocalDateTime fecha;
	private float total;
	
	@JsonIgnore
	private ClienteModel cliente;
	@JsonIgnore
	private LocalModel local;

	public CarritoModel() {
	}

	public CarritoModel(int idCarrito, Set<PedidoModel> listaPedido, LocalDateTime fecha, float total, ClienteModel cliente) {
		super();
		this.idCarrito=idCarrito;
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

	public Set<PedidoModel> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(Set<PedidoModel> listaPedido) {
		this.listaPedido = listaPedido;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	
	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", listaPedido=" + listaPedido + ", fecha=" + fecha + ", total="
				+ total + ", cliente=" + cliente + "]";
	}

	

}
