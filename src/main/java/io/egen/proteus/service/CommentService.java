package io.egen.proteus.service;

import java.util.List;

import io.egen.proteus.entity.Comment;
import io.egen.proteus.exception.TitleNotFoundException;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
public interface CommentService {
	
	public Comment registerComment(Comment comment) throws TitleNotFoundException;	
	
	public List<Comment> getComments(String imdbId) throws TitleNotFoundException;

}
