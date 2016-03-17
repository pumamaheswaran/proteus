package io.egen.proteus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.proteus.dto.AuthTokenDTO;
import io.egen.proteus.entity.User;
import io.egen.proteus.exception.InvalidLoginCredentialsException;
import io.egen.proteus.exception.LoginRequiredException;
import io.egen.proteus.exception.UserAlreadyExistsException;
import io.egen.proteus.exception.UserNotFoundException;
import io.egen.proteus.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controller for all user related operations.
 * @author Pravin Umamaheswaran
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Create a user",notes="Returns the created user")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public User createUser(@RequestBody User user) throws UserAlreadyExistsException {
		System.out.println("*****"+ user.getLastName() + user.getRole() + user.getSalt());
		return service.createUser(user);
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="User login service", notes="Returns authentication header")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public AuthTokenDTO userLogin(@RequestBody User user) throws UserNotFoundException, InvalidLoginCredentialsException {
		return service.login(user);
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	@ApiOperation(value="User logout service", notes="Has no return value")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public AuthTokenDTO logoutUser(@RequestHeader(value="Authorization") String token) throws LoginRequiredException {
				
		return service.signout(token);		
	}
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Test user service", notes="Returns empty user object")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public User test() {
		return new User();
	}
}