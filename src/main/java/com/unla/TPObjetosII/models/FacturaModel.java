package com.unla.TPObjetosII.models;

public class FacturaModel {
	 
	private int idFactura;
	private LocalModel local;
	private CarritoModel carrito;
	
	public FacturaModel(LocalModel local, CarritoModel carrito) {
		super();
		this.local = local;
		this.carrito = carrito;
	}

	public int getIdFactura() {
		return idFactura;
	}

	protected void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
	}

	public CarritoModel getCarrito() {
		return carrito;
	}

	public void setCarrito(CarritoModel carrito) {
		this.carrito = carrito;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", local=" + local + ", carrito=" + carrito + "]";
	}
	
	
	

}
