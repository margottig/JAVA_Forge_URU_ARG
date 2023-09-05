package com.dojo.advancedqueries.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.advancedqueries.services.WorldService;

@RestController
public class APIController {
	
	private final WorldService worldService;
	
	public APIController(WorldService wServ) {
		this.worldService = wServ;
	}
	
	@GetMapping("/")
	public List<Object[]> paisesPorRegion(){
		return worldService.getPaisesPorRegion(); 
	}
	
	@GetMapping("/{idioma}")
	public List<Object[]> getPaisporIdioma(@PathVariable("idioma") String idioma){
		return worldService.paisesPorIdioma(idioma);
	}
	

	
}
