package io.egen.proteus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Pravin Umamaheswaran
 *
 */
@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Title with imdbId not found")
public class TitleNotFoundException extends Exception {	
	private static final long serialVersionUID = -5522449519349152638L;
}
