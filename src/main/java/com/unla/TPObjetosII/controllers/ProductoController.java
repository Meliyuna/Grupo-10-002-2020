package com.unla.TPObjetosII.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.TPObjetosII.helpers.ViewRouteHelper;
import com.unla.TPObjetosII.services.IProductoService;
import com.unla.TPObjetosII.entities.Producto;
import com.unla.TPObjetosII.models.ProductoModel;


@Controller
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@GetMapping("/")
	public ModelAndView productos() {
	
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTOS);
		List<Producto> productos = new ArrayList<Producto>();
		productos = productoService.getAll();
		mAV.addObject("productos",productos);
		return mAV;
	}
	
	@GetMapping("/nuevo")
	public ModelAndView nuevoProducto() {
		
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_FORMULARIO);
		mAV.addObject("producto", new ProductoModel());
		return mAV;
	}
	
	@PostMapping("/")
	public RedirectView nuevoProducto(@ModelAttribute("producto") ProductoModel productoModel) {
		productoModel.setFechaAlta(LocalDate.now());
		productoService.insertOrUpdate(productoModel);
		return new RedirectView(ViewRouteHelper.PRODUCTO_REDIRECT);
	}
	
	@PostMapping("/actualizar")
	public RedirectView productoModicado(@ModelAttribute("producto") ProductoModel productoModel) {
		productoService.insertOrUpdate(productoModel);
		return new RedirectView(ViewRouteHelper.PRODUCTO_REDIRECT);
	}
	
	@PostMapping("/eliminar/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		productoService.remove(id);
		return new RedirectView(ViewRouteHelper.PRODUCTO_REDIRECT);
	}
	
	
	@GetMapping("/actualizar")
	public ModelAndView actualizarProducto() {
		ModelAndView mAV =new ModelAndView(ViewRouteHelper.PRODUCTO_ACTUALIZAR);
		List<Producto> productos = new ArrayList<Producto>();
		productos = productoService.getAll();
		mAV.addObject("productos",productos);
		return mAV;
	}
	@GetMapping("/actualizar/{id}")
	public ModelAndView parcial(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_PARCIAL);
		mAV.addObject("producto", productoService.findByIdProducto(id));
		return mAV;
	}
	
	@GetMapping("/alta")
	public String alta() {
		return "/producto/alta";
	}
	
	@GetMapping("/modificacion")
	public String modificacion(){
		return "/producto/modificar";
	}
	
	@GetMapping("/listado")
	public String listado(){
		return "/producto/listado";
	}

}
