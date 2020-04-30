package com.unla.TPObjetosII.models;

import java.time.LocalDate;

public class ClienteModel extends PersonaModel{
	
	private String email;

	public ClienteModel(String apellido, String nombre, LocalDate fechaNacimiento, long dni, String email) {
		super(apellido, nombre, fechaNacimiento, dni);
		// TODO Auto-generated constructor stub
		this.email=email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Cliente [ idPersona=" + idPersona + ", apellido=" + apellido + ", nombre=" + nombre
				+ ", fechaNacimiento=" + fechaNacimiento + ", dni=" + dni + " email=" + email + "]\n";
	}
	
	
	
	

}
