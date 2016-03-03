package io.egen.proteus.service;

import java.util.Calendar;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.egen.proteus.entity.User;
import io.egen.proteus.exception.InvalidLoginCredentialsException;
import io.egen.proteus.exception.UserAlreadyExistsException;
import io.egen.proteus.exception.UserNotFoundException;
import io.egen.proteus.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

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

	@Override
	public String login(User user) throws UserNotFoundException, InvalidLoginCredentialsException {
		
		String email = user.getEmail();
		String password = user.getPassword();
		
		User u = dao.findUserByEmail(email);
		String token = null;
		if(u != null) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				Calendar c = Calendar.getInstance();
				c.setTime(new Date());
				c.add(Calendar.DATE, 1);
				token = Jwts.builder().setSubject(email)
			            .claim("roles", u.getRole()).setExpiration(c.getTime()).setIssuedAt(new Date())
			            .signWith(SignatureAlgorithm.HS256, "secretkey").compact();				
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
	public String signout(String token) {
		token = token.substring(7);
		
		Claims claims = Jwts.parser().setSigningKey("secretkey")
			    .parseClaimsJws(token).getBody();
		claims.setExpiration(new Date());
		
		token = Jwts.builder().setSubject(claims.getSubject())
	            .setExpiration(new Date()).setClaims(claims)
	            .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		
		return token;
	}	
}