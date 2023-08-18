package com.dojo.waterbnb.services;

import org.springframework.stereotype.Service;

import com.dojo.waterbnb.models.ComentarioModel;
import com.dojo.waterbnb.repositories.CommentRepo;

@Service
public class CommentService {
	
	private final CommentRepo commentRepo;
	public CommentService(CommentRepo cRe) {
		this.commentRepo = cRe;
	}
	
	public ComentarioModel agregarComentario(ComentarioModel comentario) {
		return commentRepo.save(comentario);
	}

}
