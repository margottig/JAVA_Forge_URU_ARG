package com.dojo.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.eventos.models.EventModel;
import com.dojo.eventos.models.Provincias;
import com.dojo.eventos.models.User;
import com.dojo.eventos.services.EventService;
import com.dojo.eventos.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class EventController {
	
	private final EventService eventService;
	private final UserService userServ;
	public EventController(EventService eSer, UserService uSer ) {
		this.eventService = eSer;
		this.userServ = uSer;
	}
	
	@PostMapping("/nuevo/evento")
	public String crearEvento(@Valid @ModelAttribute("evento") EventModel evento, 
			BindingResult resultado, HttpSession sesion, Model viewModel) {
		//validar si la sesion del usuario esta activa
		Long userId =  (Long) sesion.getAttribute("userID");
		if(userId == null ) {
			return "redirect:/";
		}
		if (resultado.hasErrors()) {
			User usuario = userServ.encontrarUserPorId(userId);
			viewModel.addAttribute("usuario", usuario);
			viewModel.addAttribute("provincias", Provincias.provincias);
			return "dashboard.jsp";
		}
		eventService.crearEvento(evento);
		return "redirect:/events";
	}
	
	

}
