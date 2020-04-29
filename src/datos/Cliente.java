package datos;

import java.time.LocalDate;

public class Cliente extends Persona{
	
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
