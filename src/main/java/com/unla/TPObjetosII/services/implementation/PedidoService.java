package com.unla.TPObjetosII.services.implementation;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.PedidoConverter;
import com.unla.TPObjetosII.converters.SolicitudStockConverter;
import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.entities.Lote;
import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.entities.Producto;
import com.unla.TPObjetosII.entities.SolicitudStock;
import com.unla.TPObjetosII.models.LocalModel;
import com.unla.TPObjetosII.models.PedidoModel;
import com.unla.TPObjetosII.models.SolicitudStockModel;
import com.unla.TPObjetosII.repositories.ILoteRepository;
import com.unla.TPObjetosII.repositories.IPedidoRepository;
import com.unla.TPObjetosII.repositories.ISolicitudStockRepository;
import com.unla.TPObjetosII.services.ILoteService;
import com.unla.TPObjetosII.services.IPedidoService;


@Service("pedidoService")
public class PedidoService implements IPedidoService {

	
	@Autowired
	@Qualifier("pedidoRepository")
	private IPedidoRepository pedidoRepository;
	
	@Autowired
	@Qualifier("solicitudStockRepository")
	private ISolicitudStockRepository solicitudStockRepository;
	
	@Autowired
	@Qualifier("loteRepository")
	private ILoteRepository loteRepository;
	
	@Autowired
	@Qualifier("pedidoConverter")
	private PedidoConverter pedidoConverter;
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("solicitudStockConverter")
	private SolicitudStockConverter solicitudStockConverter;

	public PedidoModel insertOrUpdate(PedidoModel pedidoModel) {				
		return pedidoConverter.entityToModel(pedidoRepository.save(pedidoConverter.modelToEntity(pedidoModel)));
	}

	
	public List<Pedido> getAll() {
		return pedidoRepository.findAllConTodo();
	}
	
	
	public PedidoModel getById(int idPedido) {
		return pedidoConverter.entityToModel(pedidoRepository.findByIdPedido(idPedido));
	}
	
	public boolean remove(int idPedido) {
		try {
			pedidoRepository.deleteById(idPedido);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public SolicitudStockModel altaSolicitudStock(SolicitudStockModel solicitud) {
		SolicitudStock s= solicitudStockConverter.modelToEntity(solicitud);
		LocalDate fechaActual = LocalDate.now();
		boolean aceptado=false;
		boolean pendiente=true;
		s.setFechaAbierta(fechaActual);
		s.setAceptado(aceptado);
		s.setPendiente(pendiente);
		solicitudStockRepository.save(s);
		return solicitudStockConverter.entityToModel(s);
	}


	@Override
	public SolicitudStockModel aceptarSolicitudStock(SolicitudStockModel solicitud) {
		SolicitudStock s=solicitudStockConverter.modelToEntity(solicitud);
		LocalDate fechaActual = LocalDate.now();
		boolean aceptado=true;
		boolean pendiente=false;
		s.setFechaCerrada(fechaActual);
		s.setAceptado(aceptado);
		s.setPendiente(pendiente);
		
		Local local=s.getLocal();
		Pedido pedido= s.getPedido();
		int cantidadProd=pedido.getCantidad();
		int  idProd=pedido.getProducto().getIdProducto();
		loteService.modificacionStockPrevio(local.getIdLocal(),idProd,cantidadProd);
		solicitudStockRepository.save(s);
		return solicitudStockConverter.entityToModel(s);
	}


	@Override
	public SolicitudStockModel negarSolicitudStock(SolicitudStockModel solicitud) {
		SolicitudStock s=solicitudStockConverter.modelToEntity(solicitud);
		LocalDate fechaActual = LocalDate.now();
		boolean aceptado=false;
		boolean pendiente=false;
		s.setFechaCerrada(fechaActual);
		s.setAceptado(aceptado);
		s.setPendiente(pendiente);
		solicitudStockRepository.save(s);
		return solicitudStockConverter.entityToModel(s);
	}
	
	

	
	
}
