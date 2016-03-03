package io.egen.proteus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="User not logged in.")
public class LoginRequiredException extends Exception {

	private static final long serialVersionUID = -2684362337183289302L;

}
