package io.egen.proteus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="User with email not found")
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = -4216744208536823377L;

}
