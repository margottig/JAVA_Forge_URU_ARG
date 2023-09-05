package com.dojo.advancedqueries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojo.advancedqueries.models.Country;
import com.dojo.advancedqueries.repositories.CityRepo;
import com.dojo.advancedqueries.repositories.CountryRepo;
import com.dojo.advancedqueries.repositories.LanguageRepo;

@Service
public class WorldService {

	private final CountryRepo countryRepo;
	private final CityRepo cityRepo;
	private final LanguageRepo languageRepo;

	public WorldService(CountryRepo coRepo, CityRepo ciRepo, LanguageRepo lRepo) {
		this.countryRepo = coRepo;
		this.cityRepo = ciRepo;
		this.languageRepo = lRepo;
	}
	
	
	
	public List<Object[]> getPaisesPorRegion(){
		return countryRepo.findPaisPorRegion();
		}

	public List<Object[]> paisesPorIdioma(String idioma){
		
		return countryRepo.encontrarCountryPorIdioma(idioma);
	}
}
