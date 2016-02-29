package io.egen.proteus.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.proteus.entity.User;
import io.egen.proteus.exception.UserAlreadyExistsException;
import io.egen.proteus.repository.UserRepository;

/**
 * A REST service that performs CRUD operations on users.
 * @author Pravin Umamaheswaran
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository dao;	
	
	@Override
	public User createUser(User user) throws UserAlreadyExistsException {
		User returnUser = null;
		User u = dao.findUserByEmail(user.getEmail());
		if(u==null) {
			returnUser = dao.createUser(user);
		}
		else {
			throw new UserAlreadyExistsException();
		}
		
		return returnUser;
	}	
}