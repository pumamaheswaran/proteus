package io.egen.proteus.service;

import io.egen.proteus.entity.User;
import io.egen.proteus.exception.UserAlreadyExistsException;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
public interface UserService {
	
	public User createUser(User user) throws UserAlreadyExistsException;
	
}
