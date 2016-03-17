package io.egen.proteus.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.proteus.entity.Rating;
import io.egen.proteus.entity.Title;
import io.egen.proteus.entity.User;
import io.egen.proteus.exception.TitleAlreadyExistsException;
import io.egen.proteus.exception.TitleNotFoundException;
import io.egen.proteus.exception.UnauthorizedException;
import io.egen.proteus.exception.UserNotFoundException;
import io.egen.proteus.repository.TitleRepository;
import io.egen.proteus.repository.UserRepository;
/**
 * A REST service that performs CRUD operations on movie titles.
 * @author Pravin Umamaheswaran
 *
 */
@Service
public class TitleServiceImpl implements TitleService {
	
	@Autowired
	private TitleRepository dao;
	
	@Autowired
	private UserRepository userDao;

	@Override
	public void rateTitle(Title title) throws TitleNotFoundException {
		// TODO Auto-generated method stub
		Title rateTitle = null;
		Title daoTitle = dao.findTitleByID(title.getImdbID());
		if(daoTitle!=null){
			rateTitle = dao.rateTitle(title);
		}
		else{
			throw new TitleNotFoundException();
		}		
	}

	@Override
	public List<Title> getTopRatedTitles() {
		// TODO Auto-generated method stub
		List<Title> topTitles=null;
		topTitles = dao.getTopRatedTitles();
		return topTitles;
	}

	@Override
	public Title addNewTitle(Title title, String role) throws TitleAlreadyExistsException,UnauthorizedException {
		
		if(!role.equals("admin")) {
			throw new UnauthorizedException();
		}
		
		Title newTitle = null;
		Title daoTitle = dao.findTitleByID(title.getImdbID());
		if(daoTitle==null){
			newTitle = dao.addTitle(title);
		}
		else{
			throw new TitleAlreadyExistsException();
		}
		return newTitle;
	}

	@Override
	public Title editTitle(Title title, String role) throws TitleNotFoundException,UnauthorizedException {
		
		if(!role.equals("admin")) {
			throw new UnauthorizedException();
		}
		
		Title editedTitle = null;
		Title daoTitle = dao.findTitleByID(title.getImdbID());
		if(daoTitle!=null){
			editedTitle = dao.editTitle(title);
		}
		else{
			throw new TitleNotFoundException();
		}
		return editedTitle;
	}

	@Override
	public void deleteTitle(String imdbID, String role) throws TitleNotFoundException,UnauthorizedException {
		
		if(!role.equals("admin")) {
			throw new UnauthorizedException();
		}		
		
		Title daoTitle = dao.findTitleByID(imdbID);
		if(daoTitle!=null){
			dao.deleteTitle(daoTitle);
		}
		else{
			throw new TitleNotFoundException();
		}		
	}

	@Override
	public Title getTitleDetails(String imdbId) throws TitleNotFoundException {
		Title title = dao.findTitleByID(imdbId);
		if(title == null) {
			throw new TitleNotFoundException();
		}		
		return title;
	}

	@Override
	public Rating registerRating(String email, String imdbId, Rating rating) throws TitleNotFoundException,UserNotFoundException {
		
		return dao.registerRating(email, imdbId, rating);
	}
}
