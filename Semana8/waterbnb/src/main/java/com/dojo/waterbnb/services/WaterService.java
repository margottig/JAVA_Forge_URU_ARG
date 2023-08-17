package com.dojo.waterbnb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojo.waterbnb.models.WaterModel;
import com.dojo.waterbnb.repositories.WaterRepo;

@Service
public class WaterService {
	
	private final WaterRepo waterRepo;
	public WaterService(WaterRepo wRe) {
		this.waterRepo = wRe;
	}
	
	public WaterModel crearPool(WaterModel pool) {
		return waterRepo.save(pool);
	}
	
	public List<WaterModel> encontrarPorLocacion(String location){
		return waterRepo.findByDireccion(location);
	}
	
//	public List<WaterModel> eventosHost(){
//		
//	}
	

}
