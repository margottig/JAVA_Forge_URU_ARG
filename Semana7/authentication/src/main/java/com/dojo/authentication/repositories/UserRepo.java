package com.dojo.authentication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dojo.authentication.models.User;

public interface UserRepo extends CrudRepository<User, Long> {
	
	User findByEmail(String email);
	

}
