package com.dojo.productosycategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojo.productosycategorias.models.CategoryModel;
import com.dojo.productosycategorias.models.ProductModel;

public interface CategoryRepo extends CrudRepository<CategoryModel, Long>{

	List<CategoryModel> findByProductsNotContains(ProductModel producto);
}
