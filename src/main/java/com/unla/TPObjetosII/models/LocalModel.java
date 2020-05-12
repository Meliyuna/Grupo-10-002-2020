package com.unla.TPObjetosII.models;

import java.util.Set;

public class LocalModel {
	
	private int idLocal;
	private String direccion;
	private double latitud;
	private double longitud;
	private double telefono;
	private Set<EmpleadoModel> listaEmpleado;
	private Set<FacturaModel> listaFactura;
	private Set<SolicitudStockModel> listaSolicitudStock;
	private Set<LoteModel> listaLote;
	

	public LocalModel(int idLocal, String direccion, double latitud, double longitud, double telefono){
		super();
		this.idLocal = idLocal;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.telefono = telefono;


	}

	public int getIdLocal() {
		return idLocal;
	}

	protected void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getTelefono() {
		return telefono;
	}

	public void setTelefono(double telefono) {
		this.telefono = telefono;
	}

	public Set<EmpleadoModel> getListaEmpleado() {
		return listaEmpleado;
	}

	public void setListaEmpleado(Set<EmpleadoModel> listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}

	public Set<FacturaModel> getListaFactura() {
		return listaFactura;
	}

	public void setListaFactura(Set<FacturaModel> listaFactura) {
		this.listaFactura = listaFactura;
	}

	public Set<SolicitudStockModel> getListaSolicitudStock() {
		return listaSolicitudStock;
	}

	public void setListaSolicitudStock(Set<SolicitudStockModel> listaSolicitudStock) {
		this.listaSolicitudStock = listaSolicitudStock;
	}

	public Set<LoteModel> getListaLote() {
		return listaLote;
	}

	public void setListaLote(Set<LoteModel> listaLote) {
		this.listaLote = listaLote;
	}

	@Override
	public String toString() {
		return "Local [idLocal=" + idLocal + ", direccion=" + direccion + ", latitud=" + latitud + ", longitud="
				+ longitud + ", telefono=" + telefono + ", listaEmpleado=" + listaEmpleado + "]";
	}
	
	
	
	
	

}
