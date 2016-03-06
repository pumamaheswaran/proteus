package io.egen.proteus.service;

import java.util.List;
import java.util.Set;

import io.egen.proteus.entity.Comment;
import io.egen.proteus.exception.TitleNotFoundException;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
public interface CommentService {
	
	public Set<Comment> getComments(String imdbId) throws TitleNotFoundException;

	public Comment registerComment(String string, String imdbId, Comment comment) throws TitleNotFoundException;

}
