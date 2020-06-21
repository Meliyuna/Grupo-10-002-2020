package com.unla.TPObjetosII.services.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.CarritoConverter;
import com.unla.TPObjetosII.converters.FacturaConverter;
import com.unla.TPObjetosII.entities.Carrito;
import com.unla.TPObjetosII.entities.Factura;
import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.models.CarritoModel;
import com.unla.TPObjetosII.models.FacturaModel;
import com.unla.TPObjetosII.repositories.IFacturaRepository;
import com.unla.TPObjetosII.services.IFacturaService;

@Service("facturaService")
public class FacturaService implements IFacturaService{

	@Autowired
	@Qualifier("facturaRepository")
	private IFacturaRepository facturaRepository;
	
	@Autowired
	@Qualifier("facturaConverter")
	private FacturaConverter facturaConverter;
	
	@Autowired
	@Qualifier("carritoConverter")
	private CarritoConverter carritoConverter;
	
	
	@Override
	public List<FacturaModel> traerFacturas(int idLocal) {
		Set<Factura> f =facturaRepository.findAllConTodo();
		List<FacturaModel> facturas =new ArrayList<FacturaModel>();
		for (Factura i : f) {
			if (i.getCarrito().getLocal().getIdLocal() == idLocal) {
				facturas.add(facturaConverter.entityToModel(i));
			}
		}
		return facturas;
	}


	@Override
	public FacturaModel verFacturaDetalle(int idFactura) throws Exception {
		Factura f=facturaRepository.findByIdFacturaConTodo(idFactura);
		if(f==null)throw new Exception("No existen facturas con ese id");
		Carrito carrito=f.getCarrito();
		float precio = 0;
		for(Pedido p: carrito.getListaPedido()) {
			precio+=p.getCantidad()*p.getProducto().getPrecio();
		}
		carrito.setTotal(precio);
		CarritoModel carr=carritoConverter.entityToModel(carrito);
		carr.setCantidadPedidos(carrito.getListaPedido().size());
		FacturaModel factura=facturaConverter.entityToModel(f);
		factura.setCarrito(carr);
		return factura;
	}

}
