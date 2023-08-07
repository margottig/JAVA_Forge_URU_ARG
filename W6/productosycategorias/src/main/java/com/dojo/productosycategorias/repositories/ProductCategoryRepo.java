package com.dojo.productosycategorias.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dojo.productosycategorias.models.ProductCategoryModel;

public interface ProductCategoryRepo extends CrudRepository<ProductCategoryModel,Long>{
	

}
