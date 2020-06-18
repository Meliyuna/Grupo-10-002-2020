package com.unla.TPObjetosII.controllers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.unla.TPObjetosII.models.FacturaModel;
import com.unla.TPObjetosII.services.IFacturaService;

@RestController
@RequestMapping("/api/factura")
public class FacturaRestController {
	
	
	@Autowired
	@Qualifier("facturaService")
	private IFacturaService facturaService;
	
	
	@PostMapping("/traerFacturas")
	@ResponseBody
	public List<FacturaModel> traerFacturas(@RequestBody ObjectNode o) throws Exception {
		int idLocal=o.get("idLocal").asInt();
		return facturaService.traerFacturas(idLocal);
	}
	

}
