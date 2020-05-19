package com.unla.TPObjetosII.services;

import java.util.List;

import com.unla.TPObjetosII.entities.Lote;
import com.unla.TPObjetosII.models.LoteModel;

public interface IloteService {
	public List<Lote> getAll();
	public LoteModel insertOrUpdate(LoteModel loteModel) throws Exception;
	public boolean remove(int idLote);
	public LoteModel getById(int idLote);
}
