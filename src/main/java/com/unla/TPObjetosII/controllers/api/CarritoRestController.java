package com.unla.TPObjetosII.controllers.api;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unla.TPObjetosII.models.CarritoModel;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.unla.TPObjetosII.entities.Carrito;
import com.unla.TPObjetosII.services.ICarritoService;

@RestController
@RequestMapping("/api/carrito")

public class CarritoRestController {
	
	@Autowired
	@Qualifier("carritoService")
	private ICarritoService CarritoService;
	
	@PostMapping("/alta")
	@ResponseBody
	public CarritoModel alta (@RequestBody CarritoModel carrito) throws Exception {
		System.out.println(CarritoService.insertOrUpdate(carrito));
		return carrito;
	}
	
	@PostMapping("/traerCarritos")
	@ResponseBody
	public List<Carrito> traerCarritos() throws Exception {
		return CarritoService.getAll();
	}
	
	@PostMapping("/traerCarrito")
	@ResponseBody
	public CarritoModel traerCarrito(@RequestBody ObjectNode o) throws Exception{
		System.out.println(o.get("idCarrito").asInt());
		return CarritoService.getById(o.get("idCarrito").asInt());
	}
	
//	@PostMapping("/baja")
//	@ResponseBody
//	public Boolean baja (@RequestBody ObjectNode o) throws Exception{
//		System.out.println(o.get("idCarrito").asInt());
//		if(CarritoService.remove(o.get("idCarrito").asInt())==false) throw new Exception("Error al eliminar el Carrito");
//		return true;
//	}
	
	

}
