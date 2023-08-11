package com.dojo.eventos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojo.eventos.models.EventModel;

public interface EventRepo extends CrudRepository<EventModel, Long>{
	
	List<EventModel> findByProvincia(String provincia);
	
	List<EventModel> findByProvinciaIsNot(String provincia);

}
