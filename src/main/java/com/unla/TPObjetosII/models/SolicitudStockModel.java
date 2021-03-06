package com.unla.TPObjetosII.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class SolicitudStockModel {
	
	private int idSolicitudStock;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)  
	@JsonSerialize(using = LocalDateSerializer.class) 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fechaAbierta;
	@JsonDeserialize(using = LocalDateDeserializer.class)  
	@JsonSerialize(using = LocalDateSerializer.class) 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate fechaCerrada;
	private boolean aceptado;
	private boolean pendiente;
	
	@JsonIgnore
	private PedidoModel pedido;
	
	private LocalModel local;
	
	public SolicitudStockModel() {}
	
	public SolicitudStockModel(int idSolicitudStock,LocalDate fechaAbierta,LocalDate fechaCerrada, boolean aceptado,boolean pendiente, PedidoModel pedido, LocalModel local) {
		super();
		this.idSolicitudStock = idSolicitudStock;
		this.fechaAbierta = fechaAbierta;
		this.fechaCerrada = fechaCerrada;
		this.aceptado = aceptado;
		this.pendiente = pendiente;
		this.pedido = pedido;
		this.local = local;
	}
	
	public SolicitudStockModel(LocalDate fechaAbierta,LocalDate fechaCerrada, boolean aceptado,boolean pendiente, PedidoModel pedido, LocalModel local) {
		super();
		this.fechaAbierta = fechaAbierta;
		this.fechaCerrada = fechaCerrada;
		this.aceptado = aceptado;
		this.pendiente = pendiente;
		this.pedido = pedido;
		this.local = local;
	}

	public int getIdSolicitudStock() {
		return idSolicitudStock;
	}

	protected void setIdSolicitudStock(int idSolicitudStock) {
		this.idSolicitudStock = idSolicitudStock;
	}

	public LocalDate getFechaAbierta() {
		return fechaAbierta;
	}

	public void setFechaAbierta(LocalDate fechaAbierta) {
		this.fechaAbierta = fechaAbierta;
	}
	
	public LocalDate getFechaCerrada() {
		return fechaCerrada;
	}

	public void setFechaCerrada(LocalDate fechaCerrada) {
		this.fechaCerrada = fechaCerrada;
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


	public boolean getPendiente() {
		return pendiente;
	}

	public void setPendiente(boolean pendiente) {
		this.pendiente = pendiente;
	}

	@Override
	public String toString() {
		return "SolicitudStockModel [idSolicitudStock=" + idSolicitudStock + ", fechaAbierta=" + fechaAbierta
				+ ", fechaCerrada=" + fechaCerrada + ", aceptado=" + aceptado + ", pendiente=" + pendiente + ", pedido="
				+ pedido + ", local=" + local + "]";
	}

	
	
	

}
