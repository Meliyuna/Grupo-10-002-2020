package com.unla.TPObjetosII.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.TPObjetosII.entities.Carrito;
import com.unla.TPObjetosII.entities.Cliente;
import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.entities.Factura;
import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.models.CarritoModel;
import com.unla.TPObjetosII.models.ClienteModel;
import com.unla.TPObjetosII.models.EmpleadoModel;
import com.unla.TPObjetosII.models.FacturaModel;
import com.unla.TPObjetosII.models.LocalModel;
import com.unla.TPObjetosII.converters.CarritoConverter;

@Component("facturaConverter")
public class FacturaConverter {
	
	@Autowired
	@Qualifier("facturaConverter")
	private FacturaConverter facturaConverter;
	
	@Autowired
	@Qualifier("carritoConverter")
	private CarritoConverter carritoConverter;
	
	@Autowired
	@Qualifier("clienteConverter")
	private ClienteConverter clienteConverter;
	
	@Autowired
	@Qualifier("empleadoConverter")
	private EmpleadoConverter empleadoConverter;
	
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;
	

	public FacturaModel entityToModel(Factura factura) {
		if(factura==null) return null;
		CarritoModel carrito=carritoConverter.entityToModel(factura.getCarrito());
		ClienteModel cliente=clienteConverter.entityToModel(factura.getCliente());
		EmpleadoModel empleado=empleadoConverter.entityToModel(factura.getEmpleado());
		return new FacturaModel(factura.getIdFactura(),carrito,cliente,empleado,factura.getFechaFacturado());
	}
	
	
	public Factura modelToEntity(FacturaModel factura) {
		if(factura==null) return null;
		Carrito carrito=carritoConverter.modelToEntity(factura.getCarrito());
		Cliente cliente=clienteConverter.modelToEntity((factura.getCliente()));
		Empleado empleado=empleadoConverter.modelToEntity(factura.getEmpleado());
		return new Factura(factura.getIdFactura(),carrito,cliente,empleado,factura.getFechaFacturado());
	}

}
