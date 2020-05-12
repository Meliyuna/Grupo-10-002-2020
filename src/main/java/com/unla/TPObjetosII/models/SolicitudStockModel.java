package com.unla.TPObjetosII.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SolicitudStockModel {
	
	private int idSolicitudStock;
	private LocalDate fecha;
	private boolean aceptado;
	
	@JsonIgnore
	private PedidoModel pedido;
	
	@JsonIgnore
	private LocalModel local;
	
	public SolicitudStockModel() {}
	
	public SolicitudStockModel(LocalDate fecha, boolean aceptado, PedidoModel pedido, LocalModel local) {
		super();
		this.fecha = fecha;
		this.aceptado = aceptado;
		this.pedido = pedido;
		this.local = local;
	}

	public int getIdSolicitudStock() {
		return idSolicitudStock;
	}

	protected void setIdSolicitudStock(int idSolicitudStock) {
		this.idSolicitudStock = idSolicitudStock;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public PedidoModel getPedido() {
		return pedido;
	}

	public void setPedido(PedidoModel pedido) {
		this.pedido = pedido;
	}

	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "SolicitudStock [idSolicitudStock=" + idSolicitudStock + ", fecha=" + fecha + ", aceptado=" + aceptado
				+ ", pedido=" + pedido + ", local=" + local + "]\n";
	}
	
	
	

}
