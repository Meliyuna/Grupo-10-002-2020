package com.unla.TPObjetosII.models;


import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CarritoModel {

	private int idCarrito;
	
	@JsonIgnore
	private List<PedidoModel> listaPedido;
	private LocalDateTime fecha;
	private float total;
	
	
	@JsonIgnore
	private LocalModel local;
	
	@JsonIgnore
	private FacturaModel factura;
	
	private int cantidadPedidos;
	
	private boolean facturable;

	public CarritoModel() {
	}

	public CarritoModel(int idCarrito, List<PedidoModel> listaPedido, LocalDateTime fecha, float total) {
		super();
		this.idCarrito=idCarrito;
		this.listaPedido = listaPedido;
		this.fecha = fecha;
		this.total = total;
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	protected void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public List<PedidoModel> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<PedidoModel> listaPedido) {
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

	
	
	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
	}

	
	
	public FacturaModel getFactura() {
		return factura;
	}

	public void setFactura(FacturaModel factura) {
		this.factura = factura;
	}

	public int getCantidadPedidos() {
		return cantidadPedidos;
	}

	public void setCantidadPedidos(int cantidadPedidos) {
		this.cantidadPedidos = cantidadPedidos;
	}

	public boolean getFacturable() {
		return facturable;
	}

	public void setFacturable(boolean facturable) {
		this.facturable = facturable;
	}

	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", listaPedido=" + listaPedido + ", fecha=" + fecha + ", total="
				+ total+ "]";
	}

	

}
