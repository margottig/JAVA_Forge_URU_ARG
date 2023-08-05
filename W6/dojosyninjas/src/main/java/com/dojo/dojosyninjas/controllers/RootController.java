package com.dojo.dojosyninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController{
	
	@GetMapping("/")
	public String raiz() {
		return "redirect:/dojos";
	}
	
}