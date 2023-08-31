package com.dojo.dojosyninjas.controllers;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.dojosyninjas.models.NinjaModel;
import com.dojo.dojosyninjas.services.MainService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {

	//Inyeccion Dependencias
	private final MainService mainServ;
	public NinjaController(MainService service) {
		this.mainServ = service;
	}
	
	@GetMapping("/ninja/new")
	public String formNinja(@ModelAttribute("ninjaform") NinjaModel ninja, Model viewModel) {
		viewModel.addAttribute("dojos", mainServ.todosDojos());
		return "/ninjas/nuevoninja.jsp";
	}
	
	
	@PostMapping("/ninja/new")
	public String nuevoNinja(@Valid @ModelAttribute("ninjaform") NinjaModel ninja, 
			BindingResult resultado, Model viewModel) {
		if(resultado.hasErrors()) {
			System.out.println(ninja.getAge()+ " MENSAJE IMPORTANTE "+ resultado.getFieldErrors());
			viewModel.addAttribute("dojos", mainServ.todosDojos());
			return "/ninjas/nuevoninja.jsp";
		}
		mainServ.crearNinja(ninja);
		return "redirect:/dojos";
		
		
	}
	
	// ruta para segmetacion o paginacion
	@GetMapping("/pages/{numberPage}")
	public String obtenerNinjasPorPage(Model viewModel, 
			@PathVariable("numberPage") int numberPage) {
		Page<NinjaModel> ninjas = mainServ.ninjasPorPag(numberPage-1);
		
		long totalPaginas = ninjas.getTotalPages() ;
		
		viewModel.addAttribute("ninjas", ninjas);
		viewModel.addAttribute("totalpaginas", totalPaginas);
		
		return "pagination.jsp";
	}

}