package com.unla.TPObjetosII.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Persona {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IDPERSONA")
	protected int idPersona;
	protected String apellido;
	protected String nombre;
	
	@Column(name="FECHANACIMIENTO")
	protected LocalDate fechaNacimiento;
	protected long dni;
	
	public Persona() {
		
	}
	
	public Persona(String apellido, String nombre, LocalDate fechaNacimiento, long dni) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.dni = dni;
	}

	public int getIdPersona() {
		return idPersona;
	}

	protected void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", apellido=" + apellido + ", nombre=" + nombre
				+ ", fechaNacimiento=" + fechaNacimiento + ", dni=" + dni + "]";
	}
	
	
	
	
	
}
