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
public class ProductoSerivce implements IProductoService{

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
		public boolean remove(int id) {
			try {
				productoRepository.deleteById(id);
				return true;
			}catch (Exception e) {
				return false;
			}
		}
	


}
