package com.dojo.dojosyninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojo.dojosyninjas.models.NinjaModel;

public interface NinjaRepo extends CrudRepository<NinjaModel, Long> {

	List<NinjaModel> findAll();
}
