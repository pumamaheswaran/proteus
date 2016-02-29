package io.egen.proteus.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.egen.proteus.entity.User;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;
		
	@Override
	public User findUserByEmail(String emailId) {
		User user = em.find(User.class, emailId);
		return user;
	}

	@Override
	public User createUser(User user) {
		em.persist(user);
		return user;
	}

}
