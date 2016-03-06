package io.egen.proteus.repository;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import io.egen.proteus.entity.Comment;
import io.egen.proteus.entity.Title;
import io.egen.proteus.entity.User;

@Repository
@Transactional
public class CommentsRepositoryImpl implements CommentsRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Set<Comment> getComments(String imdbId) {
		Title title = em.find(Title.class, imdbId);
		return title.getComments();
	}

	@Override
	public Comment registerComment(String email, String imdbId, Comment comment) {
		User user = em.find(User.class, email);		
		Title title = em.find(Title.class, imdbId);
		
		comment.setTitle(title);
		comment.setUser(user);
		
		em.persist(comment);
		
		return comment;
	}

}
