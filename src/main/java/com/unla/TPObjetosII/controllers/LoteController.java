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

import com.unla.TPObjetosII.entities.Local;
import com.unla.TPObjetosII.entities.Lote;
import com.unla.TPObjetosII.entities.Producto;
import com.unla.TPObjetosII.helpers.ViewRouteHelper;
import com.unla.TPObjetosII.models.LoteModel;
import com.unla.TPObjetosII.models.ProductoModel;
import com.unla.TPObjetosII.services.ILocalService;
import com.unla.TPObjetosII.services.ILoteService;
import com.unla.TPObjetosII.services.IProductoService;

@Controller
@RequestMapping("/lotes")
public class LoteController {

	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("localService")
	private ILocalService localService;
	
	@GetMapping("/")
	public ModelAndView lotes() {
	
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTES);
		List<Lote> lotes = new ArrayList<Lote>();
		lotes = loteService.getAll();
		mAV.addObject("lotes",lotes);
		return mAV;
	}
	
	@GetMapping("/nuevo")
	public ModelAndView nuevoLote() {
		
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTE_FORMULARIO);
		mAV.addObject("lote", new LoteModel());
		mAV.addObject("productos", productoService.getAll());
		mAV.addObject("locales", localService.getAll());
		return mAV;
	}
	
	@PostMapping("/")
	public RedirectView nuevoLote(@ModelAttribute("lote") LoteModel loteModel) {
		loteModel.setFechaIngreso(LocalDate.now());
		loteModel.setEstado(true);
		loteService.insertOrUpdate(loteModel);
		return new RedirectView(ViewRouteHelper.LOTE_REDIRECT);
	}
	
	@GetMapping("/actualizar")
	public ModelAndView actualizarLote() {
		ModelAndView mAV =new ModelAndView(ViewRouteHelper.LOTE_ACTUALIZAR);
		List<Lote> lotes = new ArrayList<Lote>();
		lotes = loteService.getAll();
		mAV.addObject("lotes",lotes);
		return mAV;
	}
	
	@PostMapping("/actualizar")
	public RedirectView loteModicado(@ModelAttribute("lote") LoteModel loteModel) {
		loteModel.setEstado(true);
		loteService.insertOrUpdate(loteModel);
		return new RedirectView(ViewRouteHelper.LOTE_REDIRECT);
	}
	
	@GetMapping("/actualizar/{id}")
	public ModelAndView parcial(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LOTE_PARCIAL);
		mAV.addObject("lote", loteService.findByIdLote(id));
		mAV.addObject("productos", productoService.getAll());
		mAV.addObject("locales", localService.getAll());
		return mAV;
	}
	
	@PostMapping("/eliminar/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		loteService.remove(id);
		return new RedirectView(ViewRouteHelper.LOTE_REDIRECT);
	}
	
	@GetMapping("/alta")
	public String alta() {
		return "/lote/alta";
	}
	
	@GetMapping("/modificacion")
	public String modificacion(){
		return "/lote/modificar";
	}
	
	@GetMapping("/listado")
	public String listado(){
		return "/lote/listado";
	}
}
