package com.dojo.waterbnb.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojo.waterbnb.models.WaterModel;

public interface WaterRepo extends CrudRepository<WaterModel, Long>{
	
	List<WaterModel> findByDireccion(String location);

}
