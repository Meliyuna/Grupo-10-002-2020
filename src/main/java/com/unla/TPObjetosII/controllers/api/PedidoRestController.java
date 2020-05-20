package com.unla.TPObjetosII.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unla.TPObjetosII.models.ProductoModel;
import com.unla.TPObjetosII.services.ILocalService;

@RestController
@RequestMapping("/api/pedido")
public class PedidoRestController {
	
	@PostMapping("/traerProductos")
	@ResponseBody
	public List<ProductoModel> traerProductos() {
		//TODO
		return null;
	}

}
