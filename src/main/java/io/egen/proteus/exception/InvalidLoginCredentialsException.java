package io.egen.proteus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="The login credentials provided is invalid")
public class InvalidLoginCredentialsException extends Exception {

	private static final long serialVersionUID = 7295387174725448510L;

}
