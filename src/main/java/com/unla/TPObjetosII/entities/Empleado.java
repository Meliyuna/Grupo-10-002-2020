package com.unla.TPObjetosII.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="IDEMPLEADO")
public class Empleado extends Persona{
	
	@Column(name="FRANJAHORARIA")
	private String franjaHoraria;
	@Column(name="TIPOEMPLEADO")
	private boolean tipoEmpleado;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IDLOCAL")
	private Local local;
	
	
	public Empleado(){
		
	}
	
	public Empleado(int idPersona, String apellido, String nombre, LocalDate fechaNacimiento, long dni,String franjaHoraria,boolean tipoEmpleado,Local local) {
		super(idPersona, apellido, nombre, fechaNacimiento, dni);
		// TODO Auto-generated constructor stub
		this.franjaHoraria=franjaHoraria;
		this.tipoEmpleado=tipoEmpleado;
		this.local=local;
	}

	public String getFranjaHoraria() {
		return franjaHoraria;
	}

	public void setFranjaHoraria(String franjaHoraria) {
		this.franjaHoraria = franjaHoraria;
	}

	public boolean isTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(boolean tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "Empleado [ idPersona=" + idPersona + ", apellido=" + apellido + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + ", dni=" + dni + ", franjaHoraria=" + franjaHoraria + ", tipoEmpleado=" + tipoEmpleado + ", local=" + local.getIdLocal()
				+ ","+local.getDireccion()+ " ] \n";
	}
	
	
	
	
	

}
