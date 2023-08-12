package com.dojo.eventos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojo.eventos.models.EventModel;
import com.dojo.eventos.models.MensajeModel;
import com.dojo.eventos.models.User;
import com.dojo.eventos.repositories.EventRepo;
import com.dojo.eventos.repositories.MensajeRepo;

@Service
public class EventService {
	
	private final EventRepo eventRepo;
	private final MensajeRepo mensajeRepo;
	public EventService(EventRepo eRe, MensajeRepo mRe) {
		this.eventRepo = eRe;
		this.mensajeRepo = mRe;
	}
	
	//Crear Evento
	public EventModel crearEvento(EventModel evento) {
		return eventRepo.save(evento);
	}
	// Editar Evento
	public EventModel actualizarEvento(EventModel evento) {
		return eventRepo.save(evento);
	}
	//Eliminar Evento
	public void borrarEvento(Long id) {
		eventRepo.deleteById(id);
	}
	
	//Unirse o cancelar asistencia a evento
	public void unirseCancelarEvento(EventModel evento, User usuario, boolean asistencia) {
		if(asistencia) {
			evento.getAsistentes().add(usuario);			
		}else {
			evento.getAsistentes().remove(usuario);	
		}
		eventRepo.save(evento);
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
	
	// CREAR UN MENSAJE
	public void agregarComentario(User usuario, EventModel evento, String comentario) {
		MensajeModel mensaje = new MensajeModel(usuario, evento, comentario);
		mensajeRepo.save(mensaje);
		
	}

}
