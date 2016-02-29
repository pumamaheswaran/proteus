package io.egen.proteus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="User already exists in the database")
public class UserAlreadyExistsException extends Exception {
	private static final long serialVersionUID = -7334763508208692281L;
}
