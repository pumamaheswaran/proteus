package io.egen.proteus.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import io.egen.proteus.entity.Rating;
import io.egen.proteus.entity.Title;
import io.egen.proteus.entity.User;
/**
 * 
 * @author Omkar Gadgil
 *
 */
@Repository
@Transactional
public class TitleRepositoryImpl implements TitleRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Title findTitleByID(String imdbID){
		Title title = em.find(Title.class, imdbID);
		return title;
	}
	
	@Override
	public Title addTitle(Title title){
		em.persist(title);
		return title;
	}
	
	@Override
	public void deleteTitle(Title title){
		em.remove(em.merge(title));		
	}
	
	@Override
	public Title editTitle(Title title){
		Title oldTitle = findTitleByID(title.getImdbID());
		em.remove(oldTitle);
		em.persist(title);
		return title;
	}
	
	@Override
	public Title rateTitle(Title title){
		em.remove(title);
		em.persist(title);
		return title;
	}
	
	@Override
	public List<Title> getTopRatedTitles() {
		TypedQuery<Title> query = em.createNamedQuery("Title.getTopRatedTitles", Title.class);
    	List<Title> topRated = query.getResultList();
		return topRated;
	}

	@Override
	public Rating registerRating(String email, String imdbId, Rating rating) {
		
		User user = em.find(User.class, email);
		Title title = em.find(Title.class, imdbId);
		rating.setTitle(title);
		rating.setUser(user);
		em.persist(rating);
		return rating;
	}

}
