package com.dojo.productosycategorias.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String root(Model modelo) {
		return "index.jsp";
	}
	
}
