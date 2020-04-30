package com.unla.TPObjetosII.models;

import java.time.LocalDate;

public class LoteModel {
	
	private int idLote;
	private int cantidadInicial;
	private int cantidadActual;
	private LocalDate fechaIngreso;
	private ProductoModel producto;
	private boolean estado;
	
	public Lote(){
		
	}
	
	
	
	
	public Lote(int cantidadInicial, int cantidadActual, LocalDate fechaIngreso, Producto producto, boolean estado) {
		super();
		this.cantidadInicial = cantidadInicial;
		this.cantidadActual = cantidadActual;
		this.fechaIngreso = fechaIngreso;
		this.producto = producto;
		this.estado = estado;
	}




	public int getIdLote() {
		return idLote;
	}
	protected void setIdLote(int idLote) {
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
	
	@Override
	public String toString() {
		return "Lote [idLote=" + idLote + ", cantidadInicial=" + cantidadInicial + ", cantidadActual=" + cantidadActual
				+ ", fechaIngreso=" + fechaIngreso + ", producto=" + producto + ", estado=" + estado + "]";
	}
	
	
	

}
