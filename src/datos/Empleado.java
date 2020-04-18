package datos;

import java.time.LocalDate;

public class Empleado extends Persona{
	
	private String franjaHoraria;
	private boolean tipoEmpleado;
	private Local local;
	
	public Empleado(String apellido, String nombre, LocalDate fechaNacimiento, long dni,String franjaHoraria,boolean tipoEmpleado,Local local) {
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

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "Empleado [ idPersona=" + idPersona + ", apellido=" + apellido + ", nombre=" + nombre + ", fechaNacimiento="
				+ fechaNacimiento + ", dni=" + dni + ", franjaHoraria=" + franjaHoraria + ", tipoEmpleado=" + tipoEmpleado + ", local=" + local
				+ "] \n";
	}
	
	
	
	
	

}
