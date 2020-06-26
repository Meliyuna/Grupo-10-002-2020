package com.unla.TPObjetosII.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unla.TPObjetosII.entities.Producto;

public class LoteModel {
	
	private int idLote;
	private int cantidadInicial;
	private int cantidadActual;
	private LocalDate fechaIngreso;
	
	@JsonIgnore
	private ProductoModel producto;
	private boolean estado;
	private LocalModel local;
	

	public LoteModel(int idLote, int cantidadInicial, int cantidadActual, LocalDate fechaIngreso,
			ProductoModel producto, boolean estado, LocalModel local) {
		super();
		this.idLote = idLote;
		this.cantidadInicial = cantidadInicial;
		this.cantidadActual = cantidadActual;
		this.fechaIngreso = fechaIngreso;
		this.producto = producto;
		this.estado = estado;
		this.local = local;
	}


	public LoteModel(int cantidadInicial, int cantidadActual, LocalDate fechaIngreso, ProductoModel producto,
			boolean estado, LocalModel local) {
		super();
		this.cantidadInicial = cantidadInicial;
		this.cantidadActual = cantidadActual;
		this.fechaIngreso = fechaIngreso;
		this.producto = producto;
		this.estado = estado;
		this.local = local;
	}



	public LoteModel() {
		super();
	}


	public int getIdLote() {
		return idLote;
	}
	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}
	public int getCantidadInicial() {
		return cantidadInicial;
	}
	public void setCantidadInicial(int cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}
	public int getCantidadActual() {
		return cantidadActual;
	}
	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public ProductoModel getProducto() {
		return producto;
	}
	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	public LocalModel getLocal() {
		return local;
	}


	public void setLocal(LocalModel local) {
		this.local = local;
	}


	@Override
	public String toString() {
		return "LoteModel [idLote=" + idLote + ", cantidadInicial=" + cantidadInicial + ", cantidadActual="
				+ cantidadActual + ", fechaIngreso=" + fechaIngreso + ", producto=" + producto + ", estado=" + estado
				+ ", local=" + local + "]";
	}

}
