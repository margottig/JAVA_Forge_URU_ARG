package com.dojo.holamundo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundo {

	@RequestMapping("")
	public String bienvenida() {
		return "HOLA MUNDO";
	}

	@GetMapping("/hoy")
	public String hoy() {
		return "<h1>Hoy es un gran dia</h1>";
	}

	@GetMapping("/manana")
	public String manana() {
		return "Mañana sera una gran dia";
	}

	// Parametro de Consulta
	@RequestMapping("/buscar")
	public String index(@RequestParam(value = "q", required = false) String consulta) {
		return "Ha buscado:  " + consulta;
	}

	@GetMapping("/m/{track}/{module}/{lesson}")
	public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module,
			@PathVariable("lesson") String lesson) {
		return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
	}
	
	@RequestMapping("/saludos")
	public String hello(
			@RequestParam(value="nombre", required=false) String nombre, 
			@RequestParam(value="apellido", required=false) String apellido,
			@RequestParam(value="veces", required=false) Integer veces) {
		if(veces != null && veces > 0) {
			String salida = "";
			for(int i = 0; i < veces; i++) {
				if(nombre != null && apellido != null) {
					salida += "Hola " + nombre + " " + apellido + " ";
				}else if(nombre != null) {
					salida += "Hola " + nombre + " ";
				}else if(apellido != null) {
					salida += "Hola " + apellido + " ";
				}else {
					salida += "Hola Humano ";
				}
			}
			return salida;
		}
		
		if(nombre != null && apellido != null) {
			return "Hola " + nombre + " " + apellido;
		}else if(nombre != null) {
			return "Hola " + nombre;
		}else if(apellido != null) {
			return "Hola " + apellido;
		}
		return "Hola Humano";
	}

}
