package com.unla.TPObjetosII.converters;


import org.springframework.stereotype.Component;

import com.unla.TPObjetosII.entities.Producto;
import com.unla.TPObjetosII.models.ProductoModel;

@Component ("productoConverter")
public class ProductoConverter {

	public ProductoModel entityToModel(Producto producto) {
		if(producto==null)return null;
		return new ProductoModel(producto.getIdProducto(),producto.getNombre(),producto.getDescripcion(),producto.getPrecio(),producto.getFechaAlta());
	}
	
	public Producto modelToEntity(ProductoModel productoModel) {
		if(productoModel==null)return null;
		return new Producto(productoModel.getIdProducto(),productoModel.getNombre(),productoModel.getDescripcion(),productoModel.getPrecio(),productoModel.getFechaAlta());
	}

	
}
