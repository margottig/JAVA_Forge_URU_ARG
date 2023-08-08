package com.dojo.productosycategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojo.productosycategorias.models.ProductModel;


public interface ProductRepo extends CrudRepository<ProductModel, Long>{
	
List<ProductModel> findAll();
}
