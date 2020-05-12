package com.unla.TPObjetosII.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EmpleadoModel extends PersonaModel{
	
	private String franjaHoraria;
	private boolean tipoEmpleado;
	
	@JsonIgnore
	private LocalModel local;
	
	public EmpleadoModel(String apellido, String nombre, LocalDate fechaNacimiento, long dni,String franjaHoraria,boolean tipoEmpleado,LocalModel local) {
		super(apellido, nombre, fechaNacimiento, dni);
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

	public LocalModel getLocal() {
		return local;
	}

	public void setLocal(LocalModel local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "Empleado [ idPersona=" + idPersona + ", apellido=" + apellido + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + ", dni=" + dni + ", franjaHoraria=" + franjaHoraria + ", tipoEmpleado=" + tipoEmpleado + ", local=" + local
				+ "] \n";
	}
	
	
	
	
	

}
