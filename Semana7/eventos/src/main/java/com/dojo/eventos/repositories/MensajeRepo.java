package com.dojo.eventos.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dojo.eventos.models.MensajeModel;

public interface MensajeRepo extends CrudRepository<MensajeModel, Long> {

}
