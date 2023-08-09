package com.dojo.authentication.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.dojo.authentication.models.User;
import com.dojo.authentication.repositories.UserRepo;

@Service
public class UserService {
	
	private final UserRepo userRepo;
	public UserService(UserRepo uRe) {
		this.userRepo = uRe;
	}
	
	// registar al usuario
	public User registroUsuario(User user, BindingResult resultado) {
		
		User usuarioRegistrado = userRepo.findByEmail(user.getEmail());
		
		if(usuarioRegistrado != null) {
			resultado.rejectValue("email", "Matches", "Correo electronico ya existe");
		}
		if(!user.getPassword().equals(user.getPasswordConfirmation())) {
			resultado.rejectValue("password", "Matches", "Password no coincide");
		}
		if(resultado.hasErrors()) {
			return null;
		}
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
		
	}
	

}
