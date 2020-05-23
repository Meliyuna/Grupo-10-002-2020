package com.unla.TPObjetosII.services.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.PedidoConverter;
import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.models.PedidoModel;
import com.unla.TPObjetosII.repositories.IPedidoRepository;
import com.unla.TPObjetosII.services.IPedidoService;


@Service("pedidoService")
public class PedidoService implements IPedidoService {

	
	@Autowired
	@Qualifier("pedidoRepository")
	private IPedidoRepository pedidoRepository;
	
	@Autowired
	@Qualifier("pedidoConverter")
	private PedidoConverter pedidoConverter;

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
	}catch(Exception e) {
		e.printStackTrace();
		return false;
	}
}
	
}
