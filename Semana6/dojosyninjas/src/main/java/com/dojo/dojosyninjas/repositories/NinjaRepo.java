package com.dojo.dojosyninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dojo.dojosyninjas.models.NinjaModel;

public interface NinjaRepo extends CrudRepository<NinjaModel, Long> , PagingAndSortingRepository<NinjaModel, Long> {

	List<NinjaModel> findAll();
	
	
}
