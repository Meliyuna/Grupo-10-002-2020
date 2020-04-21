package datos;

import java.time.LocalDate;

public class Carrito {
	
	private int idCarrito;
	private LocalDate fecha;
	private float total;
	private Cliente cliente;
	
	public Carrito () {}
	
	public Carrito(int idCarrito, LocalDate fecha, float total, Cliente cliente) {
		
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.total = total;
		this.cliente = cliente;
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", total=" + total + ", cliente=" + cliente
				+ "]\n";
	}
	
	
	

}
