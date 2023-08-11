package com.dojo.eventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojo.eventos.models.EventModel;
import com.dojo.eventos.repositories.EventRepo;

@Service
public class EventService {
	
	private final EventRepo eventRepo;
	public EventService(EventRepo eRe) {
		this.eventRepo = eRe;
	}
	
	//Crear Evento
	public EventModel crearEvento(EventModel evento) {
		return eventRepo.save(evento);
	}
	// Editar Evento
	public EventModel actualizarEvento(EventModel evento) {
		return eventRepo.save(evento);
	}
	
	public List<EventModel> eventoProvinciaUsuario(String provincia){
		return eventRepo.findByProvincia(provincia);
	}
	
	public List<EventModel> eventoNoProvinciaUsuario(String provincia){
		return eventRepo.findByProvinciaIsNot(provincia);
	}
	
	public EventModel unEvento(Long id) {
		return eventRepo.findById(id).orElse(null);
	}

}
