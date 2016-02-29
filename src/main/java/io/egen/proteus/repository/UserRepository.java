package io.egen.proteus.repository;

import io.egen.proteus.entity.User;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
public interface UserRepository {
	
	public User findUserByEmail(String emailId);
	
	public User createUser(User user);
	
}
