package io.egen.proteus.service;

import java.util.List;

import io.egen.proteus.entity.Title;
import io.egen.proteus.exception.TitleAlreadyExistsException;
import io.egen.proteus.exception.TitleNotFoundException;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
public interface TitleService {
	
	public void rateTitle(Title title) throws TitleNotFoundException;
	
	public List<Title> getTopRatedTitles();
	
	public Title addNewTitle(Title title) throws TitleAlreadyExistsException;
	
	public Title editTitle(Title title) throws TitleNotFoundException;
	
	public void deleteTitle(String imdbID) throws TitleNotFoundException;
}
