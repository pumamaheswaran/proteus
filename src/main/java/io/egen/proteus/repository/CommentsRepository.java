package io.egen.proteus.repository;

import java.util.Set;

import io.egen.proteus.entity.Comment;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
public interface CommentsRepository {
	
	public Comment registerComment(String email, String imdbId, Comment comment);
	
	public Set<Comment> getComments(String imdbId);

}
