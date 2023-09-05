package com.dojo.advancedqueries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dojo.advancedqueries.models.Country;

public interface CountryRepo extends CrudRepository<Country, Integer> {

	
	@Query(value="SELECT c.region, COUNT(c.id) AS numero_countries FROM countries c group by c.region order by numero_countries DESC ", nativeQuery=true)
	//List<Country> findPaisPorRegion();
	List<Object[]> findPaisPorRegion();
	
	
	@Query(value="SELECT c.name, l.language, l.percentage  FROM countries c\r\n"
			+ "INNER JOIN languages l WHERE language LIKE %?1% ORDER BY l.percentage DESC", nativeQuery=true)
	List<Object[]> encontrarCountryPorIdioma(String lang);
	
}
