package com.unla.TPObjetosII.entities;


import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Carrito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDCARRITO")
	private int idCarrito;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.REMOVE)
	@JoinColumn(name="IDCARRITO")
	@OrderBy("idPedido ASC")
	private Set<Pedido> listaPedido;

	private LocalDateTime fecha;

	private float total;
	
	
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDLOCAL")
	private Local local;
	
	@JsonIgnore
	@OneToOne(mappedBy = "carrito", fetch=FetchType.LAZY)
	private Factura factura;

	public Carrito() {
	}

	public Carrito(int idCarrito, Set<Pedido> listaPedido, LocalDateTime fecha, float total) {
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

	public Set<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(Set<Pedido> listaPedido) {
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

	
	

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	
	
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", listaPedido=" + listaPedido + ", fecha=" + fecha + ", total="
				+ total + "]";
	}

	

}
