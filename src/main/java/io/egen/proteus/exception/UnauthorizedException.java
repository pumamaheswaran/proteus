package io.egen.proteus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="User unauthorized to perform this operation")
public class UnauthorizedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9100512355176503369L;

}
