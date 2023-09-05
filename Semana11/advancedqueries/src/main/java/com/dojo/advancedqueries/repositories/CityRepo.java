package com.dojo.advancedqueries.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dojo.advancedqueries.models.City;

public interface CityRepo extends CrudRepository<City, Integer> {

}
