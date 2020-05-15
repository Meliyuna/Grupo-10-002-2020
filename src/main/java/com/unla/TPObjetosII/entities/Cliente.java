package com.unla.TPObjetosII.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@PrimaryKeyJoinColumn(name="IDCLIENTE")
public class Cliente extends Persona{
	
	@Column (name="EMAIL")
	private String email;
	

	public Cliente() {
		
	}
	
	public Cliente(int idPersona, String apellido, String nombre, LocalDate fechaNacimiento, long dni, String email) {
		super(idPersona, apellido, nombre, fechaNacimiento, dni);
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
