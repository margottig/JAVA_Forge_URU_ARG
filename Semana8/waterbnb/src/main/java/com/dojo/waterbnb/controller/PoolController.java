package com.dojo.waterbnb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String index(HttpSession sesion, Model viewModel) {
		Long userLog = (Long) sesion.getAttribute("userID");
		if (userLog == null) {
			return "redirect:/";
		}
		User usuario = userService.encontrarUserPorId(userLog);
		viewModel.addAttribute("usuario", usuario);
		return "index.jsp";
	}

	@PostMapping("/search")
	public String search(@RequestParam(value = "location") String location, Model viewModel, HttpSession sesion,
			RedirectAttributes resultado) {
		Long userLog = (Long) sesion.getAttribute("userID");
		List<WaterModel> eventosWater = waterService.encontrarPorLocacion(location);
		if (userLog == null) {
			if (location.equals("")) {
				
				viewModel.addAttribute("pools", eventosWater);
				viewModel.addAttribute("usuario", userLog);
				return "searchForm.jsp";
			}
			return "redirect:/guest/signin";
		}
		viewModel.addAttribute("usuario", userLog);
		viewModel.addAttribute("pools", eventosWater);

		return "searchForm.jsp";
	}

	@GetMapping("/host/dashboard")
	public String index(@ModelAttribute("newpool") WaterModel pool, HttpSession sesion, Model viewModel) {
		Long userLog = (Long) sesion.getAttribute("userID");
		if (userLog == null) {
			return "redirect:/guest/signin";
		}
		User usuario = userService.encontrarUserPorId(userLog);
		if (usuario.getRol().equals(2)) {
			return "redirect:/search";
		}
		viewModel.addAttribute("usuario", usuario);
		return "/host/dashboard.jsp";
	}

	@PostMapping("/new/pool")
	public String nuevaPool(@Valid @ModelAttribute("newpool") WaterModel pool, BindingResult resultado) {
		if (resultado.hasErrors()) {
			return "/host/dashboard.jsp";
		}
		waterService.crearPool(pool);
		return "redirect:/host/dashboard";

	}
	
	@GetMapping("/pools/{idPool}")
	public String encontrarPool(@PathVariable("idPool")Long idPool,
			Model viewModel, HttpSession sesion) {
		Long userLog = (Long) sesion.getAttribute("userID");
		if (userLog == null) {
			return "redirect:/guest/signin";
		}
		User usuario = userService.encontrarUserPorId(userLog);
		WaterModel unaPool = waterService.encontrarPollPorId(idPool);
		viewModel.addAttribute("usuario", usuario);
		viewModel.addAttribute("pool", unaPool);
		
		return "showPool.jsp";
	}

}
