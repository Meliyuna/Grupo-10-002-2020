package com.unla.TPObjetosII.services;

import java.util.List;

import com.unla.TPObjetosII.entities.Lote;
import com.unla.TPObjetosII.models.LoteModel;
import com.unla.TPObjetosII.models.ProductoModel;

public interface ILoteService {
	public List<Lote> getAll();
	public LoteModel findByIdLote(int idLote);
	public LoteModel insertOrUpdate(LoteModel loteModel);
	public boolean remove(int idLote);
	public List<ProductoModel> ProductosXlocal(int idLocal);
	public ProductoModel ProductoXlocal(int idProducto, int idLocal);

}
