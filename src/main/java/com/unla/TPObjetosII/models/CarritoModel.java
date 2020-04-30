package com.unla.TPObjetosII.models;


import java.time.LocalDate;
import java.util.Set;

public class CarritoModel {

	private int idCarrito;
	private Set<PedidoModel> listaPedido;
	private LocalDate fecha;
	private float total;
	private ClienteModel cliente;

	public CarritoModel() {
	}

	public CarritoModel(Set<PedidoModel> listaPedido, LocalDate fecha, float total, ClienteModel cliente) {
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

	public Set<PedidoModel> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(Set<PedidoModel> listaPedido) {
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

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", listaPedido=" + listaPedido + ", fecha=" + fecha + ", total="
				+ total + ", cliente=" + cliente + "]";
	}

	

}
