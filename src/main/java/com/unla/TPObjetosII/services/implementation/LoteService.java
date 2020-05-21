package com.unla.TPObjetosII.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.LoteConverter;
import com.unla.TPObjetosII.converters.ProductoConverter;
import com.unla.TPObjetosII.entities.Lote;
import com.unla.TPObjetosII.entities.Producto;
import com.unla.TPObjetosII.models.LoteModel;
import com.unla.TPObjetosII.models.ProductoModel;
import com.unla.TPObjetosII.repositories.ILoteRepository;
import com.unla.TPObjetosII.services.ILoteService;
import com.unla.TPObjetosII.repositories.IProductoRepository;

@Service("loteService")
public class LoteService implements ILoteService{
	@Autowired
	@Qualifier("loteRepository")
	private ILoteRepository loteRepository;
	
	@Autowired
	@Qualifier("productoRepository")
	private IProductoRepository productoRepository;
	
	@Autowired
	@Qualifier("loteConverter")
	private LoteConverter loteConverter;
	
	@Autowired
	@Qualifier("productoConverter")
	private ProductoConverter productoConverter;

	@Override
	public LoteModel insertOrUpdate(LoteModel loteModel) {
		return loteConverter.entityToModel(loteRepository.save(loteConverter.modelToEntity(loteModel)));
	}
	
	@Override
	public LoteModel findByIdLote(int idLote) {
		return loteConverter.entityToModel(loteRepository.findByIdLote(idLote));
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

	@Override
	public List<ProductoModel> ProductosXlocal(int idLocal){
		
		List<Producto> todosLosProductos =productoRepository.findAll();
		List<ProductoModel>	productosDelLocal = new ArrayList<ProductoModel>();


		for(Producto p: todosLosProductos) {
			List<Lote> lotes=	loteRepository.lotesXproductoXlocal(p.getIdProducto(), idLocal);
			int cantidad=0;
			ProductoModel producto = null;
			if(!lotes.isEmpty()) {
			for(Lote l: lotes) {
				if(producto==null) {
					producto= productoConverter.entityToModel(l.getProducto());
					cantidad = l.getCantidadActual();
				}else {
				if(producto.getIdProducto()==l.getProducto().getIdProducto())cantidad += l.getCantidadActual();
				}
			}
			producto.setCantidad(cantidad);
			productosDelLocal.add(producto);
		}
		}
		if(productosDelLocal.isEmpty())return null;
		else return productosDelLocal;
	}
	@Override
	public ProductoModel ProductoXlocal(int idProducto, int idLocal ){
		List<Lote> lotes= loteRepository.lotesXproductoXlocal(idProducto, idLocal);
		if (!lotes.isEmpty()) {
		int cantidad=0;
		ProductoModel producto = productoConverter.entityToModel(lotes.get(0).getProducto());
		for(Lote l: lotes) {
			cantidad += l.getCantidadActual();
		}
		producto.setCantidad(cantidad);
		return producto;
		}else return null;
	}
	
	@Override
	public List<Lote> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
