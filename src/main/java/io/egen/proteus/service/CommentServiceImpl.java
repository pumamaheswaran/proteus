package io.egen.proteus.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.proteus.entity.Comment;
import io.egen.proteus.exception.TitleNotFoundException;
import io.egen.proteus.repository.CommentsRepository;
/**
 * A REST service that performs CRUD operations on comments.
 * @author Pravin Umamaheswaran
 *
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentsRepository dao;
	
	@Override
	public Comment registerComment(String email, String imdbId, Comment comment) throws TitleNotFoundException {
		return dao.registerComment(email, imdbId, comment);
	}

	@Override
	public Set<Comment> getComments(String imdbId) throws TitleNotFoundException {
		return dao.getComments(imdbId);
	}	
}
