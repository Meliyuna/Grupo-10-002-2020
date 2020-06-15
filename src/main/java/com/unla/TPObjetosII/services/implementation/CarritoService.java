package com.unla.TPObjetosII.services.implementation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.CarritoConverter;
import com.unla.TPObjetosII.converters.FacturaConverter;
import com.unla.TPObjetosII.converters.LocalConverter;
import com.unla.TPObjetosII.entities.Carrito;
import com.unla.TPObjetosII.entities.Factura;
import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.models.CarritoModel;
import com.unla.TPObjetosII.models.FacturaModel;
import com.unla.TPObjetosII.models.LocalModel;
import com.unla.TPObjetosII.models.PedidoModel;
import com.unla.TPObjetosII.repositories.ICarritoRepository;
import com.unla.TPObjetosII.repositories.IFacturaRepository;
import com.unla.TPObjetosII.services.ICarritoService;
import com.unla.TPObjetosII.services.ILoteService;


@Service("carritoService")
public class CarritoService implements ICarritoService{

	
	@Autowired
	@Qualifier("carritoRepository")
	private ICarritoRepository carritoRepository;
	
	@Autowired
	@Qualifier("facturaRepository")
	private IFacturaRepository facturaRepository;
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("carritoConverter")
	private CarritoConverter carritoConverter;
	
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;
	
	@Autowired
	@Qualifier("facturaConverter")
	private FacturaConverter facturaConverter;

	public CarritoModel insertOrUpdate(CarritoModel carritoModel) {				
		return carritoConverter.entityToModel(carritoRepository.save(carritoConverter.modelToEntity(carritoModel)));
	}

	
	public List<Carrito> getAll() {
		return carritoRepository.findAllConTodo();
	}
	
	public List<CarritoModel> getAll(int idLocal){
		List<Carrito> carritos = carritoRepository.findAllByIdLocal(idLocal);
		List<CarritoModel> carritosModel = new ArrayList<CarritoModel>();
		CarritoModel carritoModel = null;
		float precio = 0;
		for(Carrito c: carritos) {
			carritoModel = carritoConverter.entityToModel(c);
			precio = 0;
			for(Pedido p: c.getListaPedido()) {
				precio+=p.getCantidad()*p.getProducto().getPrecio();
			}
			carritoModel.setTotal(precio);
			carritoModel.setCantidadPedidos(c.getListaPedido().size());
			carritosModel.add(carritoModel);
		}
		return carritosModel;
	}
	
	public CarritoModel getById(int idCarrito) {
		return carritoConverter.entityToModel(carritoRepository.findByIdCarrito(idCarrito));
	}

	
	public boolean remove(int idCarrito) {
		try {
			Carrito carrito=carritoRepository.findByIdCarrito(idCarrito);
			List<Pedido> pedidos = new ArrayList<Pedido>();
			for(Pedido p: carrito.getListaPedido()) {
				pedidos.add(p);
			}
			this.loteService.devolverStockPedidosCancelados(pedidos);
			carritoRepository.delete(carrito);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public CarritoModel getByIdConTodo(int idCarrito) {
		CarritoModel c=carritoConverter.entityToModel(carritoRepository.findCarritoConTodo(idCarrito));
		int precio = 0;
		for(PedidoModel p: c.getListaPedido()) {
			precio+=p.getCantidad()*p.getProducto().getPrecio();
		}
		c.setTotal(precio);
		c.setCantidadPedidos(c.getListaPedido().size());
		return c;
	}

	@Override
	public FacturaModel generarFactura(int idCarrito) {
		LocalModel local=localConverter.entityToModel(carritoRepository.findByIdCarritoFetchLocal(idCarrito).getLocal());
		Local l=localConverter.modelToEntity(local);
		Carrito c=carritoRepository.findCarritoConTodo(idCarrito);
		Factura f= new Factura(c,null);
		facturaRepository.save(f);
		return facturaConverter.entityToModel(f);
	}
	

}
