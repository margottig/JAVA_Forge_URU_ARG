package com.dojo.dojosyninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dojo.dojosyninjas.models.NinjaModel;
import com.dojo.dojosyninjas.services.MainService;

@Controller
public class NinjaController {

	//Inyeccion Dependencias
	private final MainService mainServ;
	public NinjaController(MainService service) {
		this.mainServ = service;
	}
	
	@GetMapping("/ninja/new")
	public String formNinja(@ModelAttribute("ninja") NinjaModel ninja, Model viewModel) {
		viewModel.addAttribute("dojos", mainServ.todosDojos());
		return "/ninjas/nuevoninja.jsp";
	}

}