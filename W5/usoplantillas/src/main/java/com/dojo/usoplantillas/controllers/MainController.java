package com.dojo.usoplantillas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/root")
public class MainController {
	
	@RequestMapping("/primeraplantilla")
	public String raiz(Model modelo) {
		
		//Variable del metodo raiz
		String nombre = "Grace Hopper";
		String itemName = "Cooper wire";
		double precio = 5.75;
		String descripcion =  " Metal strips";
				
		// Incluir las variables anteriores dentro de un objeto
		modelo.addAttribute("name", nombre);
		modelo.addAttribute("itemNombre", itemName);
		modelo.addAttribute("price", precio);
		modelo.addAttribute("desc", descripcion);
		
				
		return "index.jsp";
	}

}
