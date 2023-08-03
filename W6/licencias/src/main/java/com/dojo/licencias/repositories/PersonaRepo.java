package com.dojo.licencias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.licencias.models.Persona;

@Repository
public interface PersonaRepo extends CrudRepository<Persona, Long> {
	
	List<Persona> findAll();

}
