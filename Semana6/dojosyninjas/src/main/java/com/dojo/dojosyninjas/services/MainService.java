package com.dojo.dojosyninjas.services;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dojo.dojosyninjas.models.DojoModel;
import com.dojo.dojosyninjas.models.NinjaModel;
import com.dojo.dojosyninjas.repositories.DojoRepo;
import com.dojo.dojosyninjas.repositories.NinjaRepo;
import com.dojo.dojosyninjas.repositories.NinjaRepoPage;

@Service
public class MainService {
	
	//INYECCION DEPENDENCIAS
	private final DojoRepo dojoRepo;
	private final NinjaRepo ninjaRepo;
	private final NinjaRepoPage ninjaRepoPage;
	public MainService(DojoRepo dojoR, NinjaRepo ninjaR, NinjaRepoPage ninjaRP ) {
		this.dojoRepo = dojoR;
		this.ninjaRepo = ninjaR;
		this.ninjaRepoPage = ninjaRP;
	}
	
	//variable para determinar cuantos registros por pagina
	private static final int PAGE_SIZE = 3;
	
	//METODOS CREATE
	public DojoModel crearDojo(DojoModel dojo) {
		return dojoRepo.save(dojo);
	}
	public NinjaModel crearNinja(NinjaModel ninja) {
		return ninjaRepo.save(ninja);
	}
	
	
	//METODOS LEER
	public List<DojoModel> todosDojos(){
		return dojoRepo.findAll();
	}
	public List<NinjaModel> todosNinjas(){
		return ninjaRepo.findAll();
	}
	
	public DojoModel unDojo(Long id) {
		return dojoRepo.findById(id).orElse(null);
		
	}
	
	
	//METODO PARA SEGMENTAR INFO (AKA pagination)
	public Page<NinjaModel> ninjasPorPag(int numeroPag){
		PageRequest solicitudPagina = PageRequest.of(numeroPag, 
				PAGE_SIZE, Sort.Direction.ASC, "dojo.name");
		
		return ninjaRepoPage.findAll(solicitudPagina);
	}
	

}
