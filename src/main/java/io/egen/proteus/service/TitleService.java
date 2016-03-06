package io.egen.proteus.service;

import java.util.List;

import io.egen.proteus.entity.Rating;
import io.egen.proteus.entity.Title;
import io.egen.proteus.exception.TitleAlreadyExistsException;
import io.egen.proteus.exception.TitleNotFoundException;
import io.egen.proteus.exception.UnauthorizedException;
import io.egen.proteus.exception.UserNotFoundException;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
public interface TitleService {	
	
	public void rateTitle(Title title) throws TitleNotFoundException;
	
	public List<Title> getTopRatedTitles();
	
	public Title addNewTitle(Title title, String role) throws TitleAlreadyExistsException,UnauthorizedException;
	
	public Title editTitle(Title title, String role) throws TitleNotFoundException,UnauthorizedException;
	
	public void deleteTitle(String imdbID, String role) throws TitleNotFoundException,UnauthorizedException;

	public Title getTitleDetails(String imdbId) throws TitleNotFoundException;

	public Rating registerRating(String subject, String imdbId, Rating rating) throws TitleNotFoundException, UserNotFoundException;
}
