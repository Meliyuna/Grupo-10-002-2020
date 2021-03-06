package com.unla.TPObjetosII.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.LoteConverter;
import com.unla.TPObjetosII.converters.ProductoConverter;
import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.entities.Lote;
import com.unla.TPObjetosII.entities.Pedido;
import com.unla.TPObjetosII.entities.Producto;
import com.unla.TPObjetosII.models.LoteModel;
import com.unla.TPObjetosII.models.PedidoModel;
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
	public List<ProductoModel>  CantidadProductoXlocal(int idLocal){
		
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
		}else {
			producto=productoConverter.entityToModel(p);
			producto.setCantidad(0);
			productosDelLocal.add(producto);
		}
		}
		return productosDelLocal;
	}

	@Override
	public ProductoModel ProductoXlocal(int idProducto, int idLocal) {
		List<Lote> lotes = loteRepository.lotesXproductoXlocal(idProducto, idLocal);
		if (!lotes.isEmpty()) {
			int cantidad = 0;
			ProductoModel producto = productoConverter.entityToModel(lotes.get(0).getProducto());
			for (Lote l : lotes) {
				cantidad += l.getCantidadActual();
			}
			producto.setCantidad(cantidad);
			return producto;
		} else {
			ProductoModel producto = productoConverter.entityToModel(productoRepository.findByIdProducto(idProducto));
			producto.setCantidad(0);
			return producto;
		}
	}
	
	@Override
	public List<Lote> modificacionStockPrevio(int idLocal, int idProducto,int cantidadProd) throws Exception {
		List<Lote> lotes= loteRepository.lotesXproductoXlocal(idProducto, idLocal);
		if(!lotes.isEmpty()) {
		int cantidadDisp=0;
		int cantRestante=cantidadProd;
		for(Lote l: lotes) cantidadDisp+= l.getCantidadActual();
		if(cantidadDisp<cantidadProd) throw new Exception("No hay Stock suficiente");
		for(Lote l: lotes) {	
			int cantNuevaLote = l.getCantidadActual()-cantRestante;
		    if(cantNuevaLote<0){
		    	cantRestante=cantRestante-l.getCantidadActual();
		    	l.setCantidadActual(0);
		     //   cantRestante = cantRestante + cantNuevaLote; // si es negativa es una resta
		        this.insertOrUpdate(loteConverter.entityToModel(l));
		    }
		    else{
		        l.setCantidadActual(cantNuevaLote);
		        this.insertOrUpdate(loteConverter.entityToModel(l));
		        break;
		    }
		}			
			return lotes;
		}
		return null;
	}
	
	
	@Override
	public List<Lote> modificacionStockPrevioSuma(int idLocal, int idProducto,int cantidadProd) {
		List<Lote> lotes= loteRepository.lotesXproductoXlocal(idProducto, idLocal);
		if(!lotes.isEmpty()) {
		int cantRestante=cantidadProd;
		for(Lote l: lotes) {	
			int cantNuevaLote = l.getCantidadActual()+cantRestante;
		    if(cantNuevaLote>l.getCantidadInicial()){
		    	cantRestante=cantRestante-(l.getCantidadInicial()-l.getCantidadActual());
		    	l.setCantidadActual(l.getCantidadInicial());	  
		        this.insertOrUpdate(loteConverter.entityToModel(l));
		    }
		    else{
		        l.setCantidadActual(cantNuevaLote);
		        this.insertOrUpdate(loteConverter.entityToModel(l));
		        break;
		    }
		}			
			return lotes;
		}
		return null;
	}
	
	
	@Override
    public boolean devolverStockPedidosCancelados(List<Pedido> listaPedido) {
        boolean agregado=false;
        if(!listaPedido.isEmpty()) {
            Local local=listaPedido.get(0).getCarrito().getLocal();
            System.out.println(listaPedido.get(0).getCarrito().getLocal());
            int cantidad=0;
            int idProducto=0;
            for(Pedido p: listaPedido) {
                cantidad=p.getCantidad();
                idProducto=p.getProducto().getIdProducto();
                List<Lote> lotes=loteRepository.lotesXproductoXlocal(idProducto, local.getIdLocal());
                for(Lote l: lotes) {
                    int cantidadAEntrar=l.getCantidadActual()+cantidad;
                    if(l.getCantidadInicial()>=cantidadAEntrar) {
                    l.setCantidadActual(cantidadAEntrar);
                    this.insertOrUpdate(loteConverter.entityToModel(l));
                    agregado=true;
                    break;
                    }
                    else {
                    	cantidad=cantidad-(l.getCantidadInicial()-l.getCantidadActual());
                    	l.setCantidadActual(l.getCantidadInicial());
                    	this.insertOrUpdate(loteConverter.entityToModel(l));
                    }

                }
            }
        }
        return agregado;
    }
	
	@Override
	public boolean devolverStockPedidoModificado(Pedido pedidoAnterior, Pedido pedidoNuevo) throws Exception {
		boolean cambiado = false;
		Pedido viejo = pedidoAnterior;
		Pedido nuevo = pedidoNuevo;
		int cantidadNuevo = nuevo.getCantidad();
		int cantidadViejo = viejo.getCantidad();
		Local local = viejo.getCarrito().getLocal();
		int idProducto = viejo.getProducto().getIdProducto();
		int cantidadAAgregar = cantidadViejo - cantidadNuevo;
		if (cantidadAAgregar < 0) {
			this.modificacionStockPrevio(local.getIdLocal(), idProducto, cantidadNuevo - cantidadViejo);
			cambiado=true;
		} else {
			this.modificacionStockPrevioSuma(local.getIdLocal(), idProducto, cantidadAAgregar);
			cambiado=true;
		}
		return cambiado;
	}

	
	@Override
	public List<Lote> getAll() {
		return loteRepository.findAll();
	}
	
	@Override
	public List<Lote> getAllPorLocal(int idLocal) {
		return loteRepository.findAllPorLocal(idLocal);
	}

	

	

}
