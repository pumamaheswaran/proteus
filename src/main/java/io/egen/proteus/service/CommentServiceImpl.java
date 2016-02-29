package io.egen.proteus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.egen.proteus.entity.Comment;
import io.egen.proteus.entity.Title;
import io.egen.proteus.exception.TitleNotFoundException;
/**
 * A REST service that performs CRUD operations on comments.
 * @author Pravin Umamaheswaran
 *
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Override
	public Comment registerComment(Comment comment) throws TitleNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> getComments(String imdbId) throws TitleNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}	
}
