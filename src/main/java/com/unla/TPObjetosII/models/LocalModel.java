package com.unla.TPObjetosII.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class LocalModel {
	
	private int idLocal;
	private String direccion;
	private double latitud;
	private double longitud;
	private double telefono;
	private double distancia;
	private int cantidad;
	
	@JsonIgnore
	private Set<EmpleadoModel> listaEmpleado;
	
	@JsonIgnore
	private Set<FacturaModel> listaFactura;
	
	@JsonIgnore
	private Set<SolicitudStockModel> listaSolicitudStock;
	
	@JsonIgnore
	private Set<LoteModel> listaLote;
	
	public LocalModel() {
		
	}

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

	public void setIdLocal(int idLocal) {
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

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	public double distanciaCoord(LocalModel local) {
		double radioTierra = 6371;
		double dLat = Math.toRadians(local.getLatitud()-this.getLatitud());
		double dLng = Math.toRadians(local.getLongitud()-this.getLongitud());
		double sindLat = Math.sin(dLat/2);
		double sindLng = Math.sin(dLng/2);
		double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2) * Math.cos(Math.toRadians(this.getLatitud())) * Math.cos(Math.toRadians(local.getLatitud()));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		return radioTierra * va2;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	

}
