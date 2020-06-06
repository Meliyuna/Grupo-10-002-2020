package com.unla.TPObjetosII.models;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unla.TPObjetosII.entities.SolicitudStock;

public class PedidoModel {
	
	private int idPedido;
	
	private ProductoModel producto;
	private int cantidad;
	
	private SolicitudStockModel solicitudStock;
	
	@JsonIgnore
	private EmpleadoModel vendedorOriginal;
	
	@JsonIgnore
	private EmpleadoModel vendedorAuxiliar;
	@JsonIgnore
	private CarritoModel carrito;
	private float subtotal;
	private boolean aceptado;
	
	public PedidoModel(int idPedido, ProductoModel producto, int cantidad, EmpleadoModel vendedorOriginal, EmpleadoModel vendedorAuxiliar, CarritoModel carrito,
			float subtotal, boolean aceptado, SolicitudStockModel solicitudStock) {
		super();
		this.idPedido=idPedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.solicitudStock = solicitudStock;
		this.vendedorOriginal = vendedorOriginal;
		this.vendedorAuxiliar = vendedorAuxiliar;
		this.carrito = carrito;
		this.subtotal = subtotal;
		this.aceptado = aceptado;
	}

	public PedidoModel() {
		super();
	}

	public int getIdPedido() {
		return idPedido;
	}

	protected void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public ProductoModel getProducto() {
		return producto;
	}

	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public EmpleadoModel getVendedorOriginal() {
		return vendedorOriginal;
	}

	public void setVendedorOriginal(EmpleadoModel vendedorOriginal) {
		this.vendedorOriginal = vendedorOriginal;
	}

	public EmpleadoModel getVendedorAuxiliar() {
		return vendedorAuxiliar;
	}

	public void setVendedorAuxiliar(EmpleadoModel vendedorAuxiliar) {
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

	
	
	public CarritoModel getCarrito() {
		return carrito;
	}

	public void setCarrito(CarritoModel carrito) {
		this.carrito = carrito;
	}
	
	

	public SolicitudStockModel getSolicitudStock() {
		return solicitudStock;
	}

	public void setSolicitudStock(SolicitudStockModel solicitudStock) {
		this.solicitudStock = solicitudStock;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", producto=" + producto + ", cantidad=" + cantidad 
				+ ", vendedorOriginal=" + vendedorOriginal + ", vendedorAuxiliar=" + vendedorAuxiliar + ", subtotal="
				+ subtotal + ", aceptado=" + aceptado + "]";
	}
	
	
	
	

}
