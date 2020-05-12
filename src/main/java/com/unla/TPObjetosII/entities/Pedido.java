package com.unla.TPObjetosII.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDPEDIDO")
	private int idPedido;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDPRODUCTO")
	private Producto producto;

	private int cantidad;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDLOCAL")
	private Local local;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDVENDEDORORIGINAL")
	private Empleado vendedorOriginal;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDVENDEDORAUXILIAR")
	private Empleado vendedorAuxiliar;

	private float subtotal;

	private boolean aceptado;
	
	public Pedido(){
		
	}
	
	public Pedido(Producto producto, int cantidad, Local local, Empleado vendedorOriginal, Empleado vendedorAuxiliar,
			float subtotal, boolean aceptado) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.local = local;
		this.vendedorOriginal = vendedorOriginal;
		this.vendedorAuxiliar = vendedorAuxiliar;
		this.subtotal = subtotal;
		this.aceptado = aceptado;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Empleado getVendedorOriginal() {
		return vendedorOriginal;
	}

	public void setVendedorOriginal(Empleado vendedorOriginal) {
		this.vendedorOriginal = vendedorOriginal;
	}

	public Empleado getVendedorAuxiliar() {
		return vendedorAuxiliar;
	}

	public void setVendedorAuxiliar(Empleado vendedorAuxiliar) {
		this.vendedorAuxiliar = vendedorAuxiliar;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", producto=" + producto + ", cantidad=" + cantidad + ", local=" + local
				+ ", vendedorOriginal=" + vendedorOriginal + ", vendedorAuxiliar=" + vendedorAuxiliar + ", subtotal="
				+ subtotal + ", aceptado=" + aceptado + "] \n";
	}
	
	
	
	

}
