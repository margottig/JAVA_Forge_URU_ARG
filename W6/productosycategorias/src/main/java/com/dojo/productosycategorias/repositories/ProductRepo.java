package com.dojo.productosycategorias.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dojo.productosycategorias.models.ProductModel;


public interface ProductRepo extends CrudRepository<ProductModel, Long>{
	

}
