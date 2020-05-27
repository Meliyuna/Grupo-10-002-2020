package com.unla.TPObjetosII.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.LocalConverter;
import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.models.LocalModel;
import com.unla.TPObjetosII.repositories.ILocalRepository;
import com.unla.TPObjetosII.services.ILocalService;
import com.unla.TPObjetosII.services.ILoteService;

@Service("localService")
public class LocalService implements ILocalService{
	
	@Autowired
	@Qualifier("localRepository")
	private ILocalRepository localRepository;
	
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;

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
	

	@Override
	public List<LocalModel> traerLocalesConDistancia(LocalModel local) throws Exception{
		List<Local> locales=this.getAll();
		if(locales.isEmpty())throw new Exception ("La lista de locales esta vacia");
		List<LocalModel> localesConDist= new ArrayList<LocalModel>();
		double distancia;
		for(Local l: locales) {
			if(l.getIdLocal()!=local.getIdLocal()) {
				localesConDist.add(localConverter.entityToModel(l));
			}
		}
		for(LocalModel l: localesConDist) {
			distancia=local.distanciaCoord(l);
			l.setDistancia(distancia);
		}
		return localesConDist;
	}

	@Override
	public List<LocalModel> traerLocalesConStockDistanciaYCantidad(int idProducto, LocalModel local) throws Exception {
		List<LocalModel> locales = this.traerLocalesConDistancia(local);
		List<Local> localesConProd = localRepository.localesConStock(idProducto);

		List<LocalModel> localesProd = new ArrayList<LocalModel>();

		List<LocalModel> localesAMostrar = new ArrayList<LocalModel>();

		for (Local l : localesConProd) {
			localesProd.add(localConverter.entityToModel(l));
		}
		double distancia = 0;
		int cantidad=0;
		for (LocalModel l : locales) {
			distancia = l.getDistancia();	
			for (LocalModel loc : localesProd) {
				if (loc.getIdLocal() == l.getIdLocal()) {
					cantidad=loteService.ProductoXlocal(idProducto, loc.getIdLocal()).getCantidad();
					loc.setCantidad(cantidad);
					loc.setDistancia(distancia);
					localesAMostrar.add(loc);
				}
			}
		}
		return localesAMostrar;
	}
}
