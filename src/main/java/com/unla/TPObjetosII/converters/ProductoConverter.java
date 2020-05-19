package com.unla.TPObjetosII.converters;


import org.springframework.stereotype.Component;

import com.unla.TPObjetosII.entities.Producto;
import com.unla.TPObjetosII.models.ProductoModel;

@Component ("productoConverter")
public class ProductoConverter {

	public ProductoModel entityToModel(Producto producto) {
		return new ProductoModel(producto.getIdProducto(),producto.getNombre(),producto.getDescripcion(),producto.getPrecio(),producto.getFechaAlta());
	}
	
	public Producto modelToEntity(ProductoModel productoModel) {
		return new Producto(productoModel.getIdProducto(),productoModel.getNombre(),productoModel.getDescripcion(),productoModel.getPrecio(),productoModel.getFechaAlta());
	}

	
}
