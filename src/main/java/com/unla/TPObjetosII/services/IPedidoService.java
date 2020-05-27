package com.unla.TPObjetosII.services;

import java.util.List;

import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.models.EmpleadoModel;
import com.unla.TPObjetosII.models.LocalModel;
import com.unla.TPObjetosII.models.PedidoModel;
import com.unla.TPObjetosII.models.SolicitudStockModel;


public interface IPedidoService {
	
	public List<Pedido> getAll();
	public PedidoModel getById(int idPedido);
	public PedidoModel insertOrUpdate(PedidoModel pedidoModel) throws Exception;
	public boolean remove(int idPedido);
	public SolicitudStockModel altaSolicitudStock(SolicitudStockModel solicitud);
	//public boolean remove(int idPedido);
	

}
