package com.dojo.waterbnb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dojo.waterbnb.models.WaterModel;
import com.dojo.waterbnb.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PoolController {
	
	private final UserService userService;
	public PoolController(UserService uServ) {
		this.userService = uServ;
	}
	
	@GetMapping("/host/dashboard")
	public String index(@ModelAttribute("newpool") WaterModel pool, HttpSession sesion, Model viewModel) {
		Long userLog = (Long) sesion.getAttribute("userID");
		if(userLog ==null) {
			return "redirect:/guest/signin";
		}
		viewModel.addAttribute("usuario", userService.encontrarUserPorId(userLog) );
		return "/host/dashboard.jsp";
	}
	

}
