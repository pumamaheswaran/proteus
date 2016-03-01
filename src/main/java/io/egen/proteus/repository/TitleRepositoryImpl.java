package io.egen.proteus.repository;

import java.util.List;

import io.egen.proteus.entity.Title;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
/**
 * 
 * @author Omkar Gadgil
 *
 */
@Repository
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
		em.remove(title);		
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
	public List<Title> getTopRatedTitles(){
		List<Title> topRated = null;
		return topRated;
	}

}
