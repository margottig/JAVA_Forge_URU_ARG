package com.dojo.authentication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.authentication.models.LogReg;
import com.dojo.authentication.models.User;
import com.dojo.authentication.services.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {
	
	private final UserService userServ;
	public UserController(UserService uSer) {
		this.userServ = uSer;
	}
	
	@GetMapping("/")
	public String raiz(Model viewModel) {
		viewModel.addAttribute("user", new User());
		viewModel.addAttribute("login", new LogReg());
		return "loginreg.jsp";
	}
	
	@PostMapping("/registration")
	public String registro(@Valid @ModelAttribute("user") User usuario,
			BindingResult resultado, Model viewModel ) {
		if(resultado.hasErrors()) {
			viewModel.addAttribute("login", new LogReg());
			return "loginreg.jsp";
		}
		
		
		return null;
	}

}
