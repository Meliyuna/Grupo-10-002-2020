package com.unla.TPObjetosII.services.implementation;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.CarritoConverter;
import com.unla.TPObjetosII.converters.ProductoConverter;
import com.unla.TPObjetosII.entities.Carrito;
import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.models.CarritoModel;
import com.unla.TPObjetosII.models.ProductoModel;
import com.unla.TPObjetosII.repositories.ICarritoRepository;
import com.unla.TPObjetosII.services.ICarritoService;
import com.unla.TPObjetosII.services.ILoteService;


@Service("carritoService")
public class CarritoService implements ICarritoService{

	
	@Autowired
	@Qualifier("carritoRepository")
	private ICarritoRepository carritoRepository;
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("carritoConverter")
	private CarritoConverter carritoConverter;
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

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
	
	public List<ProductoModel> carritosConPedidos() {
		List<Carrito> carritos=carritoRepository.findAllConTodo();
		List<ProductoModel> productos = new ArrayList<ProductoModel>();
		int cantidad=0;
		ProductoModel producto = null;
		for(Carrito c: carritos) {
			Set<Pedido> pedidos=c.getListaPedido();
			for(Pedido p: pedidos) {
				if(encontrarProducto(p.getProducto().getIdProducto(),productos)) {
					devolverProducto(p.getProducto().getIdProducto(),productos).setCantidad(p.getCantidad() + devolverProducto(p.getProducto().getIdProducto(), productos).getCantidad());
				}else {
					producto = productoConverter.entityToModel(p.getProducto());
					cantidad = p.getCantidad();
					producto.setCantidad(cantidad);
					productos.add(producto);
				}
			}
		}
		Collections.sort(productos,Collections.reverseOrder());
		return productos;
		
	}
	
	public List<ProductoModel> carritosConPedidos(int idLocal) {
		List<Carrito> carritos=carritoRepository.findAllConPedidos(idLocal);
		List<ProductoModel> productos = new ArrayList<ProductoModel>();
		int cantidad=0;
		ProductoModel producto = null;
		for(Carrito c: carritos) {
			Set<Pedido> pedidos=c.getListaPedido();
			for(Pedido p: pedidos) {
				if(encontrarProducto(p.getProducto().getIdProducto(),productos)) {
					devolverProducto(p.getProducto().getIdProducto(),productos).setCantidad(p.getCantidad() + devolverProducto(p.getProducto().getIdProducto(), productos).getCantidad());
				}else {
					producto = productoConverter.entityToModel(p.getProducto());
					cantidad = p.getCantidad();	
					producto.setCantidad(cantidad);
					productos.add(producto);
				}
			}
		}
		Collections.sort(productos,Collections.reverseOrder());
		return productos;
		
	}
	

	@Override
	public List<ProductoModel> carritosConPedidosEntreFechas(int idLocal, LocalDateTime desde, LocalDateTime hasta) {
		List<Carrito> carritos=carritoRepository.findAllConPedidosEntreFechas(idLocal, desde, hasta);
		List<ProductoModel> productos = new ArrayList<ProductoModel>();
		int cantidad=0;
		ProductoModel producto = null;
		for(Carrito c: carritos) {
			Set<Pedido> pedidos=c.getListaPedido();
			for(Pedido p: pedidos) {
				if(encontrarProducto(p.getProducto().getIdProducto(),productos)) {
					devolverProducto(p.getProducto().getIdProducto(),productos).setCantidad(p.getCantidad() + devolverProducto(p.getProducto().getIdProducto(), productos).getCantidad());
				}else {
					producto = productoConverter.entityToModel(p.getProducto());
					cantidad = p.getCantidad();	
					producto.setCantidad(cantidad);
					productos.add(producto);
				}
				
			}
			
		}
		Collections.sort(productos,Collections.reverseOrder());
		return productos;
	}
	public boolean encontrarProducto (int idProducto, List<ProductoModel> productos) {
		for(ProductoModel p: productos) {
			if(p.getIdProducto()==idProducto)return true;
		}
		return false;
	}

	public ProductoModel devolverProducto(int idProducto, List<ProductoModel> productos) {
		for(ProductoModel p: productos) {
			if(p.getIdProducto()==idProducto)return p;
		}
		return null;
	}

}
