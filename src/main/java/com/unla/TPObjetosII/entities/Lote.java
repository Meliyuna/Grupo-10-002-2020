package com.unla.TPObjetosII.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Lote {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDLOTE")
	private int idLote;

	@Column (name="CANTIDADINICIAL")
	private int cantidadInicial;
	@Column (name="CANTIDADACTUAL")
	private int cantidadActual;
	@Column (name="FECHAINGRESO")
	private LocalDate fechaIngreso;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDPRODUCTO")
	private Producto producto;
	
	

	public Lote(int idLote, int cantidadInicial, int cantidadActual, LocalDate fechaIngreso, Producto producto,
			boolean estado) {
		super();
		this.idLote = idLote;
		this.cantidadInicial = cantidadInicial;
		this.cantidadActual = cantidadActual;
		this.fechaIngreso = fechaIngreso;
		this.producto = producto;
		this.estado = estado;
	}

	private boolean estado;
	
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
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
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
