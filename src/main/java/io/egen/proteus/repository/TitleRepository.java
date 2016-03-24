package io.egen.proteus.repository;

import java.util.List;

import io.egen.proteus.entity.Rating;
import io.egen.proteus.entity.Title;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
public interface TitleRepository {
	
	public Title findTitleByID(String imdbID); 
	
	public Title rateTitle(Title title);
	
	public Title addTitle(Title title);
	
	public List<Title> getTopRatedTitles();
	
	public Title editTitle(Title title);
	
	public void deleteTitle(Title title);

	public Rating registerRating(String email, String imdbId, Rating rating);
	
	public List<Title> getCatalog();
}
