package io.egen.proteus.repository;

import java.util.List;

import io.egen.proteus.entity.Comment;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
public interface CommentsRepository {
	
	public void registerComment(Comment comment);
	
	public List<Comment> getComments(String imdbId);

}
