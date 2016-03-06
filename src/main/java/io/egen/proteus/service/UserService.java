package io.egen.proteus.service;

import io.egen.proteus.dto.AuthTokenDTO;
import io.egen.proteus.entity.User;
import io.egen.proteus.exception.InvalidLoginCredentialsException;
import io.egen.proteus.exception.UserAlreadyExistsException;
import io.egen.proteus.exception.UserNotFoundException;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
public interface UserService {
	
	public User createUser(User user) throws UserAlreadyExistsException;
	
	public AuthTokenDTO login(User user) throws UserNotFoundException, InvalidLoginCredentialsException;
	
	public AuthTokenDTO signout(String token);
}