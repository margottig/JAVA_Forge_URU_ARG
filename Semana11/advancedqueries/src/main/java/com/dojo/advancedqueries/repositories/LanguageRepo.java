package com.dojo.advancedqueries.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dojo.advancedqueries.models.Language;

public interface LanguageRepo extends CrudRepository<Language, Integer> {

}
