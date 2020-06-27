package com.unla.TPObjetosII.services;

import java.util.List;

import com.unla.TPObjetosII.entities.Lote;
import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.models.LoteModel;
import com.unla.TPObjetosII.models.ProductoModel;

public interface ILoteService {
	public List<Lote> getAll();
	public List<Lote> getAllPorLocal(int idLocal);
	public LoteModel findByIdLote(int idLote);
	public LoteModel insertOrUpdate(LoteModel loteModel);
	public boolean remove(int idLote);
	public List<ProductoModel> ProductosXlocal(int idLocal);
	public ProductoModel ProductoXlocal(int idProducto, int idLocal);
	public List<ProductoModel> CantidadProductoXlocal(int idLocal);
	public List<Lote> modificacionStockPrevio(int idLocal, int idProducto,int cantidadProd)throws Exception;
	public List<Lote> modificacionStockPrevioSuma(int idLocal, int idProducto,int cantidadProd);
	public boolean devolverStockPedidosCancelados(List<Pedido> listaPedido);
	public boolean devolverStockPedidoModificado(Pedido pedidoAnterior,Pedido pedidoNuevo)throws Exception;

}
