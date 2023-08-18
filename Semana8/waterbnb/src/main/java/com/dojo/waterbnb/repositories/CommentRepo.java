package com.dojo.waterbnb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dojo.waterbnb.models.ComentarioModel;

public interface CommentRepo extends CrudRepository<ComentarioModel, Long>{

}
