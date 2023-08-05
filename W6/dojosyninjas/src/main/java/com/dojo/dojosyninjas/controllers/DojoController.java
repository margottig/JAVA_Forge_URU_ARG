package com.dojo.dojosyninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.dojosyninjas.models.DojoModel;
import com.dojo.dojosyninjas.services.MainService;

import jakarta.validation.Valid;

@Controller
public class DojoController{
	
	private final MainService mainServ;
	public DojoController(MainService service) {
		this.mainServ = service;
	}
	
	@GetMapping("/dojos")
	public String index(Model viewModel) {
		viewModel.addAttribute("dojos", mainServ.todosDojos());
		return "/dojos/index.jsp";
	}
	
	@GetMapping("/dojo/new")
	public String formDojo(@ModelAttribute("dojo") DojoModel dojo) {
		
		return "/dojos/nuevodojo.jsp";
	}	
	
	@PostMapping("/dojo/new")
	public String crearPersona(@Valid @ModelAttribute("dojo") DojoModel dojo, BindingResult resultado) {
		if (resultado.hasErrors()) {

			return "/dojos/nuevodojo.jsp";
		}
		mainServ.crearDojo(dojo);
		return "redirect:/";

	}
	
	
	
	
	
}