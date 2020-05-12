package com.unla.TPObjetosII.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Local {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDLOCAL")
	private int idLocal;

	private String direccion;

	private double latitud;

	private double longitud;

	private double telefono;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="IDLOCAL")
	private Set<Empleado> listaEmpleado;
	
	@JsonIgnore
	@Transient //ignorar mapeo
	private Set<Factura> listaFactura;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn (name="IDLOCAL")
	private Set<SolicitudStock> listaSolicitudStock;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="IDLOCAL")
	private Set<Lote> listaLote;
	
	public Local(){
		
	}
	
	public Local(String direccion, double latitud, double longitud, double telefono, Set<Empleado> listaEmpleado,
			Set<Factura> listaFactura, Set<SolicitudStock> listaSolicitudStock, Set<Lote> listaLote) {
		super();
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.telefono = telefono;
		this.listaEmpleado = listaEmpleado;
		this.listaFactura = listaFactura;
		this.listaSolicitudStock = listaSolicitudStock;
		this.listaLote = listaLote;
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

	public Set<Empleado> getListaEmpleado() {
		return listaEmpleado;
	}

	public void setListaEmpleado(Set<Empleado> listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}

	public Set<Factura> getListaFactura() {
		return listaFactura;
	}

	public void setListaFactura(Set<Factura> listaFactura) {
		this.listaFactura = listaFactura;
	}

	public Set<SolicitudStock> getListaSolicitudStock() {
		return listaSolicitudStock;
	}

	public void setListaSolicitudStock(Set<SolicitudStock> listaSolicitudStock) {
		this.listaSolicitudStock = listaSolicitudStock;
	}

	public Set<Lote> getListaLote() {
		return listaLote;
	}

	public void setListaLote(Set<Lote> listaLote) {
		this.listaLote = listaLote;
	}

	@Override
	public String toString() {
		return "Local [idLocal=" + idLocal + ", direccion=" + direccion + ", latitud=" + latitud + ", longitud="
				+ longitud + ", telefono=" + telefono + "] \n";
	}


	
	
	
	
	

}
