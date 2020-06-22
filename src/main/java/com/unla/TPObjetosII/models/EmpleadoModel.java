package com.unla.TPObjetosII.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EmpleadoModel extends PersonaModel{
	
	private String franjaHoraria;
	private boolean tipoEmpleado;
	
	@JsonIgnore
	private LocalModel local;
	
	private float sueldo;
	

	public EmpleadoModel() {
		
	}
	
	public EmpleadoModel(int idEmpleado,String apellido, String nombre, LocalDate fechaNacimiento, long dni,String franjaHoraria,boolean tipoEmpleado,LocalModel local) {
		super(idEmpleado, apellido, nombre, fechaNacimiento, dni);

		// TODO Auto-generated constructor stub
		this.franjaHoraria=franjaHoraria;
		this.tipoEmpleado=tipoEmpleado;
		this.local=local;
	}

	public EmpleadoModel(int idEmpleado,String apellido, String nombre, LocalDate fechaNacimiento, long dni,String franjaHoraria,boolean tipoEmpleado) {
		super(idEmpleado, apellido, nombre, fechaNacimiento, dni);
		// TODO Auto-generated constructor stub
		this.franjaHoraria=franjaHoraria;
		this.tipoEmpleado=tipoEmpleado;
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
	
	

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	
	
	
	@Override
	public String toString() {
		return "Empleado [ idPersona=" + idPersona + ", apellido=" + apellido + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + ", dni=" + dni + ", franjaHoraria=" + franjaHoraria + ", tipoEmpleado=" + tipoEmpleado + ", local=" + local
				+ ", sueldo=" + sueldo+"] \n";
	}
	
	
	
	
	

}
