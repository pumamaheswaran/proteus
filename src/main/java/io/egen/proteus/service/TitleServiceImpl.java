package io.egen.proteus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.egen.proteus.entity.Title;
import io.egen.proteus.exception.TitleAlreadyExistsException;
import io.egen.proteus.exception.TitleNotFoundException;
/**
 * A REST service that performs CRUD operations on movie titles.
 * @author Pravin Umamaheswaran
 *
 */
@Service
public class TitleServiceImpl implements TitleService {

	@Override
	public void rateTitle(Title title) throws TitleNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Title> getTopRatedTitles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Title addNewTitle(Title title) throws TitleAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Title editTitle(Title title) throws TitleNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTitle(Title title) throws TitleNotFoundException {
		// TODO Auto-generated method stub
		
	}
}
