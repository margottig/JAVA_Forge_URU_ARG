package com.dojo.waterbnb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dojo.waterbnb.models.User;
import com.dojo.waterbnb.models.WaterModel;
import com.dojo.waterbnb.services.UserService;
import com.dojo.waterbnb.services.WaterService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PoolController {
	
	private final UserService userService;
	private final WaterService waterService;
	public PoolController(UserService uServ, WaterService wServ) {
		this.userService = uServ;
		this.waterService = wServ;
	}
	
	@GetMapping("/")
	public String raiz() {
		return "index.jsp";
	}
	
	@GetMapping("/search")
	public String index() {
		return "searchForm.jsp";
	}
	
	@PostMapping("/search")
	public String search(@RequestParam(value="location") String location,
			Model viewModel, HttpSession sesion) {
		Long userLog = (Long) sesion.getAttribute("userID");
		if(userLog ==null) {
			return "redirect:/guest/signin";
		}
//		User usuario = userService.encontrarUserPorId(userLog);
		List<WaterModel> eventosWater = waterService.encontrarPorLocacion(location);
		
		return null;
	}
	
	
	
	@GetMapping("/host/dashboard")
	public String index(@ModelAttribute("newpool") WaterModel pool, HttpSession sesion, Model viewModel) {
		Long userLog = (Long) sesion.getAttribute("userID");
		if(userLog ==null) {
			return "redirect:/guest/signin";
		}
		User usuario = userService.encontrarUserPorId(userLog);
		if(usuario.getRol().equals(2)) {
			return "redirect:/search";
		}
		viewModel.addAttribute("usuario", usuario);
		return "/host/dashboard.jsp";
	}
	
	@PostMapping("/new/pool")
	public String nuevaPool(@Valid @ModelAttribute("newpool") WaterModel pool,
			BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "/host/dashboard.jsp";
		}
		waterService.crearPool(pool);
		return "redirect:/host/dashboard";
		
	}
	
	

}
