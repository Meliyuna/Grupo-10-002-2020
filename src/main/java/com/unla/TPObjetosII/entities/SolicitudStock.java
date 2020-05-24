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
@Table(name="SOLICITUDSTOCK")
public class SolicitudStock {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDSOLICITUDSTOCK")
	private int idSolicitudStock;

	@Column(name="FECHAABIERTA")
	private LocalDate fechaAbierta;
	
	@Column(name="FECHACERRADA")
	private LocalDate fechaCerrada;

	private boolean aceptado;
	
	private boolean pendiente;
	
	
	@JsonIgnore
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="IDPEDIDO")
	private Pedido pedido;
	
	@JsonIgnore
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="IDLOCAL")
	private Local local;
	
	public SolicitudStock() {}
	
	public SolicitudStock(int idSolicitudStock,LocalDate fechaAbierta,LocalDate fechaCerrada, boolean aceptado, boolean pendiente,Pedido pedido, Local local) {
		super();
		this.idSolicitudStock=idSolicitudStock;
		this.fechaAbierta = fechaAbierta;
		this.fechaCerrada= fechaCerrada;
		this.aceptado = aceptado;
		this.pedido = pedido;
		this.local = local;
	}
	
	public SolicitudStock(LocalDate fechaAbierta,LocalDate fechaCerrada, boolean aceptado, boolean pendiente,Pedido pedido, Local local) {
		super();
		this.fechaAbierta = fechaAbierta;
		this.fechaCerrada= fechaCerrada;
		this.aceptado = aceptado;
		this.pedido = pedido;
		this.local = local;
	}

	public int getIdSolicitudStock() {
		return idSolicitudStock;
	}

	protected void setIdSolicitudStock(int idSolicitudStock) {
		this.idSolicitudStock = idSolicitudStock;
	}

	public LocalDate getFechaAbierta() {
		return fechaAbierta;
	}

	public void setFechaAbierta(LocalDate fechaAbierta) {
		this.fechaAbierta = fechaAbierta;
	}
	
	public LocalDate getFechaCerrada() {
		return fechaAbierta;
	}

	public void setFechaCerrada(LocalDate fechaCerrada) {
		this.fechaCerrada = fechaCerrada;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}



	public boolean getPendiente() {
		return pendiente;
	}

	public void setPendiente(boolean pendiente) {
		this.pendiente = pendiente;
	}

	@Override
	public String toString() {
		return "SolicitudStock [idSolicitudStock=" + idSolicitudStock + ", fechaAbierta=" + fechaAbierta
				+ ", fechaCerrada=" + fechaCerrada + ", aceptado=" + aceptado + ", pendiente=" + pendiente + ", pedido="
				+ pedido + ", local=" + local + "]";
	}

	
	
	
	

}
