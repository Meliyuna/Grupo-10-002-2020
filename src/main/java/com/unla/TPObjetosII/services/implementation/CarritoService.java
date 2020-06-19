package com.unla.TPObjetosII.services.implementation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.CarritoConverter;
import com.unla.TPObjetosII.converters.ClienteConverter;
import com.unla.TPObjetosII.converters.EmpleadoConverter;
import com.unla.TPObjetosII.converters.FacturaConverter;
import com.unla.TPObjetosII.converters.LocalConverter;
import com.unla.TPObjetosII.entities.Carrito;
import com.unla.TPObjetosII.entities.Cliente;
import com.unla.TPObjetosII.entities.Empleado;
import com.unla.TPObjetosII.entities.Factura;
import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.models.CarritoModel;
import com.unla.TPObjetosII.models.ClienteModel;
import com.unla.TPObjetosII.models.EmpleadoModel;
import com.unla.TPObjetosII.models.FacturaModel;
import com.unla.TPObjetosII.models.LocalModel;
import com.unla.TPObjetosII.models.PedidoModel;
import com.unla.TPObjetosII.repositories.ICarritoRepository;
import com.unla.TPObjetosII.repositories.IFacturaRepository;
import com.unla.TPObjetosII.repositories.IPedidoRepository;
import com.unla.TPObjetosII.services.ICarritoService;
import com.unla.TPObjetosII.services.IClienteService;
import com.unla.TPObjetosII.services.IEmpleadoService;
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
	@Qualifier("pedidoRepository")
	private IPedidoRepository pedidoRepository;
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
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
		Set<Carrito> carritos = carritoRepository.findAllByIdLocal(idLocal);
		List<CarritoModel> carritosModel = new ArrayList<CarritoModel>();
		CarritoModel carritoModel = null;
		float precio = 0;
		boolean facturable;
		for(Carrito c: carritos) {
			facturable=true;
			carritoModel = carritoConverter.entityToModel(c);
			precio = 0;
			for(Pedido p: c.getListaPedido()) {
				precio+=p.getCantidad()*p.getProducto().getPrecio();
				if(p.getSolicitudStock()!=null) {
					if(p.getSolicitudStock().getPendiente()) {
						facturable=false;
					}
				}
			}
			if(c.getListaPedido().size()==0)facturable=false;
			carritoModel.setFacturable(facturable);
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
				p.setBaja(true);
				pedidoRepository.save(p);
			}
			this.loteService.devolverStockPedidosCancelados(pedidos);
			carrito.setBaja(true);
			carritoRepository.save(carrito);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public CarritoModel getByIdConTodo(int idCarrito) {
		CarritoModel c = carritoConverter.entityToModel(carritoRepository.findCarritoConTodo(idCarrito));
		List<PedidoModel> listaPedido = c.getListaPedido();
		List<PedidoModel> listaSinRechazo = new ArrayList<PedidoModel>();
		for (PedidoModel i : listaPedido) {
			if (i.getSolicitudStock() != null) {
				if (i.getSolicitudStock().isAceptado() == true) {
					listaSinRechazo.add(i);
				}
			}
			else listaSinRechazo.add(i);
		}
		int precio = 0;
		for (PedidoModel p : listaSinRechazo) {
			precio += p.getCantidad() * p.getProducto().getPrecio();
		}
		c.setTotal(precio);
		c.setListaPedido(listaSinRechazo);
		c.setCantidadPedidos(listaSinRechazo.size());
		System.out.println(listaSinRechazo);
		return c;
	}

	@Override
	public FacturaModel generarFactura(int idCarrito, int idCliente, int idEmpleado) throws Exception {
		LocalModel local = localConverter.entityToModel(carritoRepository.findByIdCarritoFetchLocal(idCarrito).getLocal());
		Local l = localConverter.modelToEntity(local);
		CarritoModel car=this.getById(idCarrito);
		if(car==null) throw new Exception("El carrito no existe");
		ClienteModel cli=clienteService.getById(idCliente);
		if(cli==null) throw new Exception("El cliente no existe");
		EmpleadoModel e=empleadoService.getEmpleado(idEmpleado);
		if(e==null)throw new Exception("El empleado no existe");
		Carrito carrito = carritoConverter.modelToEntity(this.getByIdConTodo(idCarrito));
		Set<Pedido> pedidos = carrito.getListaPedido();
		System.out.println(pedidos);
		for (Pedido p : pedidos) {
			if (p.getSolicitudStock() != null) {
				if (p.getSolicitudStock().getPendiente() == true)
					throw new Exception("Imposible realizar factura solicitud Stock pendiente");
			}
		}
		carrito.setLocal(l);
		Cliente cliente = clienteConverter.modelToEntity(clienteService.getById(idCliente));
		Empleado empleado = empleadoConverter.modelToEntity(empleadoService.getEmpleado(idEmpleado));
		LocalDateTime ahora = LocalDateTime.now();
		Factura f = new Factura(carrito, cliente, empleado, ahora);
		List<Factura> facturas = facturaRepository.findAll();
		if (!facturas.isEmpty()) {
			for (Factura i : facturas) {
				if (i.getCarrito().getIdCarrito() == f.getCarrito().getIdCarrito()) throw new Exception("Ya existe factura con ese Carrito");
			}
		}
		facturaRepository.save(f);
		return facturaConverter.entityToModel(f);
	}

}
