package com.unla.TPObjetosII.services.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.EmpleadoConverter;
import com.unla.TPObjetosII.converters.LocalConverter;
import com.unla.TPObjetosII.converters.PedidoConverter;
import com.unla.TPObjetosII.converters.SolicitudStockConverter;
import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.entities.SolicitudStock;
import com.unla.TPObjetosII.models.EmpleadoModel;
import com.unla.TPObjetosII.models.LocalModel;
import com.unla.TPObjetosII.models.PedidoModel;
import com.unla.TPObjetosII.models.SolicitudStockModel;
import com.unla.TPObjetosII.repositories.ILocalRepository;
import com.unla.TPObjetosII.repositories.IPedidoRepository;
import com.unla.TPObjetosII.repositories.ISolicitudStockRepository;
import com.unla.TPObjetosII.services.ILocalService;
import com.unla.TPObjetosII.services.ILoteService;

@Service("localService")
public class LocalService implements ILocalService{
	
	@Autowired
	@Qualifier("localRepository")
	private ILocalRepository localRepository;
	
	@Autowired
	@Qualifier("pedidoRepository")
	private IPedidoRepository pedidoRepository;
	
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;
	
	@Autowired
	@Qualifier("pedidoConverter")
	private PedidoConverter pedidoConverter;
	
	@Autowired
	@Qualifier("pedidoService")
	private PedidoService pedidoService;
	
	@Autowired
	@Qualifier("solicitudStockConverter")
	private SolicitudStockConverter solicitudStockConverter;
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("empleadoConverter")
	private EmpleadoConverter empleadoConverter;
	
	@Autowired
	@Qualifier("solicitudStockRepository")
	private ISolicitudStockRepository solicitudStockRepository;

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
		int cantidad = 0;
		for (LocalModel l : locales) {
			distancia = l.getDistancia();
			for (LocalModel loc : localesProd) {
				if (loc.getIdLocal() == l.getIdLocal()) {
						cantidad = loteService.ProductoXlocal(idProducto, loc.getIdLocal()).getCantidad();
						loc.setCantidad(cantidad);
						loc.setDistancia(distancia);
						localesAMostrar.add(loc);	
				}

			}
		}
		return this.ordenarLocalesPorDistancia(localesAMostrar);
	}
	
	public List<LocalModel> ordenarLocalesPorDistancia(List<LocalModel> listaLocales){
		listaLocales.sort(Comparator.comparing(LocalModel::getDistancia));
		List<LocalModel> locales= new ArrayList<LocalModel>();
		int cantidadLocales=0;
		for(LocalModel l: listaLocales) {
			if(cantidadLocales<5) {
				locales.add(l);
				cantidadLocales++;
			}
		}
		return locales;
	}

	@Override
	public List<SolicitudStockModel> traerSolicitudesStock(LocalModel local) {
		List<SolicitudStockModel> lista=new ArrayList<SolicitudStockModel>();
		Local l = localRepository.traerSolicitudesStock(local.getIdLocal());
		if(l!=null) {
			for(SolicitudStock s: l.getListaSolicitudStock()) {
				lista.add(solicitudStockConverter.entityToModel((s)));
			}
		}
		return lista;
	}
	
	@Override
	public SolicitudStockModel aceptarSolicitudStock(SolicitudStockModel solicitud,EmpleadoModel vendedorAux) throws Exception{
		SolicitudStock s=solicitudStockConverter.modelToEntity(solicitud);
		LocalDate fechaActual = LocalDate.now();
		if(s==null)throw new Exception("La solicitud fue eliminada");
		if(!s.getPendiente()&&!s.isAceptado()) throw new Exception("La solicitud ya fue rechazada");
		if(!s.getPendiente()&&s.isAceptado()) throw new Exception("La solicitud ya fue aceptada");
		boolean aceptado=true;
		boolean pendiente=false;
		s.setFechaCerrada(fechaActual);
		s.setAceptado(aceptado);
		s.setPendiente(pendiente);
		
		Local local=s.getLocal();
		Pedido pedido= pedidoRepository.findByIdPedido(s.getPedido().getIdPedido());
		pedido.setVendedorAuxiliar(empleadoConverter.modelToEntity(vendedorAux));
		int cantidadProd=pedido.getCantidad();
		int  idProd=pedido.getProducto().getIdProducto();
		pedidoRepository.save(pedido);
		loteService.modificacionStockPrevio(local.getIdLocal(),idProd,cantidadProd);
		solicitudStockRepository.save(s);
		return solicitudStockConverter.entityToModel(s);
	}


	@Override
	public SolicitudStockModel negarSolicitudStock(SolicitudStockModel solicitud) throws Exception{
		SolicitudStock s=solicitudStockConverter.modelToEntity(solicitud);
		if(s==null)throw new Exception("La solicitud fue eliminada");
		if(!s.getPendiente()&&s.isAceptado()) throw new Exception("La solicitud ya fue aceptada");
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
