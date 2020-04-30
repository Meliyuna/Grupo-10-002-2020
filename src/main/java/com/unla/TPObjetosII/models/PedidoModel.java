package com.unla.TPObjetosII.models;

public class PedidoModel {
	
	private int idPedido;
	private ProductoModel producto;
	private int cantidad;
	private LocalModel local;
	private EmpleadoModel vendedorOriginal;
	private EmpleadoModel vendedorAuxiliar;
	private float subtotal;
	private boolean aceptado;
	
	public PedidoModel(ProductoModel producto, int cantidad, LocalModel local, EmpleadoModel vendedorOriginal, EmpleadoModel vendedorAuxiliar,
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

	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
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

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", producto=" + producto + ", cantidad=" + cantidad + ", local=" + local
				+ ", vendedorOriginal=" + vendedorOriginal + ", vendedorAuxiliar=" + vendedorAuxiliar + ", subtotal="
				+ subtotal + ", aceptado=" + aceptado + "]";
	}
	
	
	
	

}
