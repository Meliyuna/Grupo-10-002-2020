package com.unla.TPObjetosII.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/general")
	public ModelAndView ranking(){
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.RANKING);
		mAV.addObject("productos",carritoService.carritosConPedidos());
		return mAV;
	}
	
	@GetMapping("/fechas/{id}")
	public ModelAndView rankingFechas(@PathVariable("id") int id) {
	
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.RANKING_FECHAS);
		mAV.addObject("productos",carritoService.carritosConPedidos(id));

		return mAV;
	}
	@PostMapping("/tabla/{id}")
//	public ModelAndView rankingFechas(@PathVariable("id") int id, @RequestParam("desde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta) {
	public ModelAndView rankingFechas(@PathVariable("id") int id,@RequestParam("desde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,@RequestParam("hasta")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta)	{
		System.out.println(desde);
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.RANKING_TABLA_PRODUCTO_FECHAS);
		mAV.addObject("productos",carritoService.carritosConPedidosEntreFechas(id, desde, hasta));
		
		return mAV;
	}
	
	
	@GetMapping("")
	public String listado(){
		return "/ranking/ranking";
	}
	
	@GetMapping("/fechas")
	public String listadoFechas(){
		return "/ranking/rankingFechas";
	}
}
