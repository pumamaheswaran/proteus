package io.egen.proteus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Cannot create another title with the same imdbId")
public class TitleAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 4085098014221555956L;

}
