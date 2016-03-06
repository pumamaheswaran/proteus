package io.egen.proteus.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.proteus.dto.AuthTokenDTO;
import io.egen.proteus.entity.User;
import io.egen.proteus.exception.InvalidLoginCredentialsException;
import io.egen.proteus.exception.UserAlreadyExistsException;
import io.egen.proteus.exception.UserNotFoundException;
import io.egen.proteus.repository.UserRepository;
import io.jsonwebtoken.Claims;

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
	
	@Autowired
	private TokenService tokenService;
	
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

	@Override
	public AuthTokenDTO login(User user) throws UserNotFoundException, InvalidLoginCredentialsException {
		
		String email = user.getEmail();
		String password = user.getPassword();
		
		User u = dao.findUserByEmail(email);
		AuthTokenDTO token = null;
		if(u != null) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				token = tokenService.encryptToken(email, u.getRole(),null);				
			}
			else {
				throw new InvalidLoginCredentialsException();
			}
		}
		else {
			throw new UserNotFoundException();
		}
		return token;
	}

	@Override
	public AuthTokenDTO signout(String token) {
		token = token.substring(7);
		
		Claims claims = tokenService.decryptToken(token);
		claims.setExpiration(new Date());
		
		AuthTokenDTO authToken = tokenService.encryptToken(claims.getSubject(),
				claims.get("role",String.class), new Date());
		
		return authToken;
	}	
}