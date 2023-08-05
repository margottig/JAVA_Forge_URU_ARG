package com.dojo.dojosyninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojo.dojosyninjas.models.DojoModel;
import com.dojo.dojosyninjas.models.NinjaModel;
import com.dojo.dojosyninjas.repositories.DojoRepo;
import com.dojo.dojosyninjas.repositories.NinjaRepo;

@Service
public class MainService {
	
	//INYECCION DEPENDENCIAS
	private final DojoRepo dojoRepo;
	private final NinjaRepo ninjaRepo;
	public MainService(DojoRepo dojoR, NinjaRepo ninjaR ) {
		this.dojoRepo = dojoR;
		this.ninjaRepo = ninjaR;
	}
	
	
	//METODOS CREATE
	public DojoModel crearDojo(DojoModel dojo) {
		return dojoRepo.save(dojo);
	}
	
	
	//METODOS LEER
	public List<DojoModel> todosDojos(){
		return dojoRepo.findAll();
	}
	public List<NinjaModel> todosNinjas(){
		return ninjaRepo.findAll();
	}
	
	
	

}
