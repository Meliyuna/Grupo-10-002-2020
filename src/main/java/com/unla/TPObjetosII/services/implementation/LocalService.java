package com.unla.TPObjetosII.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.LocalConverter;
import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.models.LocalModel;
import com.unla.TPObjetosII.repositories.ILocalRepository;
import com.unla.TPObjetosII.services.ILocalService;

@Service("localService")
public class LocalService implements ILocalService{
	
	@Autowired
	@Qualifier("localRepository")
	private ILocalRepository localRepository;
	
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;

	@Override
	public LocalModel insertOrUpdate(LocalModel localModel) throws Exception {
		Local bdLocal = localRepository.findByTelefono(localModel.getTelefono());
		if(bdLocal!=null) if(bdLocal.getIdLocal()!=localModel.getIdLocal()) throw new Exception("El telefono ya existe");
		return localConverter.entityToModel(localRepository.save(localConverter.modelToEntity(localModel)));
	}

	@Override
	public List<Local> getAll() {
		return localRepository.findAllLocal();
	}
	
	@Override
	public LocalModel getById(int idLocal) {
		return localConverter.entityToModel(localRepository.findByIdLocal(idLocal));
	}

	@Override
	public boolean remove(int idLocal) {
		try {
			Local local = localRepository.findByIdLocal(idLocal);
			local.setBaja(true);
			localRepository.save(local);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
