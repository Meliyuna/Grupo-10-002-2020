package com.unla.TPObjetosII.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.LocalConverter;
import com.unla.TPObjetosII.entities.Lote;
import com.unla.TPObjetosII.models.LoteModel;
import com.unla.TPObjetosII.repositories.ILoteRepository;
@Service("loteService")
public class LoteService {
	@Autowired
	@Qualifier("loteRepository")
	private ILoteRepository localRepository;
	
	@Autowired
	@Qualifier("loteConverter")
	private LocalConverter localConverter;

	@Override
	public LoteModel insertOrUpdate(LoteModel loteModel) throws Exception {
		return loteConverter.entityToModel(loteRepository.save(loteConverter.modelToEntity(loteModel)));
	}
	
	@Override
	public LoteModel getById(int idLote) {
		return loteConverter.entityToModel(loteRepository.findBy(idLote));
	}

	@Override
	public boolean remove(int idLote) {
		try {
			loteRepository.deleteById(idLote);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
}
}
