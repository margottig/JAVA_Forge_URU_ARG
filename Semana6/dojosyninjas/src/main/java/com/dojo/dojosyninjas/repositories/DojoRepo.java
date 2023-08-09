package com.dojo.dojosyninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojo.dojosyninjas.models.DojoModel;

public interface DojoRepo extends CrudRepository<DojoModel, Long> {
	
	List<DojoModel> findAll();

}
