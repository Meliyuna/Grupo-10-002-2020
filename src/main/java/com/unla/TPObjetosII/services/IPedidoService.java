package com.unla.TPObjetosII.services;

import java.util.List;

import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.models.PedidoModel;


public interface IPedidoService {
	
	public List<Pedido> getAll();
	public PedidoModel getById(int idPedido);
	public PedidoModel insertOrUpdate(PedidoModel pedidoModel) throws Exception;
	//public boolean remove(int idPedido);

}
