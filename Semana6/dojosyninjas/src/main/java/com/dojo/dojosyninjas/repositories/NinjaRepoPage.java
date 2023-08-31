package com.dojo.dojosyninjas.repositories;

import org.springframework.data.domain.Page;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dojo.dojosyninjas.models.NinjaModel;

public interface NinjaRepoPage extends PagingAndSortingRepository<NinjaModel, Long> {

	
	Page<NinjaModel> findAll();
}
