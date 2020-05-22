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
	private Set<Pedido> listaPedido;

	private LocalDateTime fecha;

	private float total;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDCLIENTE")
	private Cliente cliente;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDLOCAL")
	private Local local;

	public Carrito() {
	}

	public Carrito(int idCarrito, Set<Pedido> listaPedido, LocalDateTime fecha, float total, Cliente cliente) {
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", listaPedido=" + listaPedido + ", fecha=" + fecha + ", total="
				+ total + ", cliente=" + cliente + "]";
	}

	

}
