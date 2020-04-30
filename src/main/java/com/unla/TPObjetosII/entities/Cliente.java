package com.unla.TPObjetosII.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table (name="cliente")
public class Cliente extends Persona{
	@Column(name="email")
	private String email;
	
	public Cliente(){
		
	}

	public Cliente(String apellido, String nombre, LocalDate fechaNacimiento, long dni, String email) {
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
