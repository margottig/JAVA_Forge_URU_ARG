package com.dojo.licencias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.licencias.models.Licencia;
import com.dojo.licencias.models.Persona;
import com.dojo.licencias.repositories.LicenciaRepo;
import com.dojo.licencias.repositories.PersonaRepo;

@Service
public class MainService {
	
	// Inyeccion Dependencias
	@Autowired
	private LicenciaRepo licenciaRepo;
	
	@Autowired 
	private PersonaRepo personaRepo;
	
	
	//SERVICIOS PARA PERSONA
	public Persona crearPersona(Persona persona) {
		return personaRepo.save(persona);
	}
	
	public List<Persona> todasPersonas(){
		return personaRepo.findAll();
	}
	
	
	//SERVICIOS PARA LICENCIA
	public Licencia crearLicencia(Licencia licencia) {
		return licenciaRepo.save(licencia);
	}
	
	public List<Persona> obtenerPersonasSinLic(){
		return personaRepo.findByLicenciaIdIsNull();
//		return personaRepo.encontrarNoLic();
	}
	
	//Metodo para generar numero de licencia
//	public int generarNumerLic() {
//		Licencia lic = 
//	}

}
