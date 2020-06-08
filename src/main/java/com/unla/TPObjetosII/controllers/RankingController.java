package com.unla.TPObjetosII.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.unla.TPObjetosII.helpers.ViewRouteHelper;
import com.unla.TPObjetosII.models.ProductoModel;
import com.unla.TPObjetosII.services.ICarritoService;


@Controller
@RequestMapping("/rankings")
public class RankingController {

	@Autowired
	@Qualifier("carritoService")
	private ICarritoService carritoService;
	
	@GetMapping("/{id}")
	public ModelAndView ranking(@PathVariable("id") int id) {
	
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.RANKING);
		mAV.addObject("productos",carritoService.carritosConPedidos(id));
		return mAV;
	}
	
	@GetMapping("")
	public String listado(){
		return "/ranking/ranking";
	}
}
