package com.unla.TPObjetosII.services.implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.TPObjetosII.converters.ProductoConverter;
import com.unla.TPObjetosII.entities.Producto;
import com.unla.TPObjetosII.models.ProductoModel;
import com.unla.TPObjetosII.repositories.IProductoRepository;
import com.unla.TPObjetosII.services.IProductoService;


@Service("productoService")
public class ProductoService implements IProductoService{

		@Autowired
		@Qualifier("productoRepository")
		private IProductoRepository productoRepository;
		
		@Autowired
		@Qualifier("productoConverter")
		private ProductoConverter productoConverter;
		
		@Override
		public List<Producto> getAll(){
			return productoRepository.findAll();
		}
		
		
		@Override
		public ProductoModel insertOrUpdate (ProductoModel productoModel) {
			Producto producto = productoRepository.save(productoConverter.modelToEntity(productoModel));
			return productoConverter.entityToModel(producto);
		}
		
		@Override
		public Producto remove(int id) {
			Producto p = productoRepository.findByIdProducto(id);
			p.setBaja(true);
			return productoRepository.save(p);
		}
	
		@Override
		public ProductoModel findByIdProducto(int id) {
			return productoConverter.entityToModel(productoRepository.findByIdProducto(id));
		}

}
