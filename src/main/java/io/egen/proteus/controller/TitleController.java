package io.egen.proteus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.proteus.entity.Rating;
import io.egen.proteus.entity.Title;
import io.egen.proteus.exception.TitleAlreadyExistsException;
import io.egen.proteus.exception.TitleNotFoundException;
import io.egen.proteus.exception.UnauthorizedException;
import io.egen.proteus.exception.UserNotFoundException;
import io.egen.proteus.service.TitleServiceImpl;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controller for all title related operations.
 * @author Pravin Umamaheswaran
 *
 */
@RestController
@RequestMapping("/api/title")
public class TitleController {	
	
	@Autowired
	private TitleServiceImpl service;
	
	@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	@ApiOperation(value="Get top rated titles",notes="Returns a list of top rated titles")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public List<Title> getTopRatedTitles() {
		return service.getTopRatedTitles();
	}
	
	@RequestMapping(path="/all",produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	@ApiOperation(value="Get all titles",notes="Returns a list of all titles")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public List<Title> getCatalog() {
		return service.getTopRatedTitles();
	}
	
	@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	@ApiOperation(value="Add a new title",notes="Returns the added title")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public Title addNewTitle(HttpServletRequest request, @RequestBody Title title) throws TitleAlreadyExistsException, UnauthorizedException {		
		Claims claims = (Claims)request.getAttribute("claims");
		String role = claims.get("role", String.class);
		return service.addNewTitle(title,role);
	}
	
	@RequestMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.PUT)
	@ApiOperation(value="Edit a title",notes="Returns the edited title")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public Title editTitle(HttpServletRequest request, @PathVariable("id") String id,@RequestBody Title title) throws TitleNotFoundException, UnauthorizedException {
		Claims claims = (Claims)request.getAttribute("claims");
		String role = claims.get("role", String.class);
		return service.editTitle(title, role);
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	@ApiOperation(value="Delete an existing title",notes="Does not have a return value")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public void deleteTitle(HttpServletRequest request,@PathVariable("id") String id) throws TitleNotFoundException, UnauthorizedException {
		
		Claims claims = (Claims)request.getAttribute("claims");
		String role = claims.get("role", String.class);
		service.deleteTitle(id,role);
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Get details of a particular title",notes="Returns title details")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public Title getTitleDetails(@PathVariable("id") String id) throws TitleNotFoundException {
		return service.getTitleDetails(id);
	}
	
	@RequestMapping(method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Get top rated titles",notes="Returns list of top rated titles")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public List<Title> getTitleDetails() {
		return service.getTopRatedTitles();
	}
	
	@RequestMapping(path="/rating/{id}",method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Rating rateTitle(HttpServletRequest request ,@PathVariable("id") String id,
			@RequestBody Rating rating) throws UserNotFoundException, TitleNotFoundException {
		Claims claims = (Claims)request.getAttribute("claims");		
		return service.registerRating(claims.getSubject(), id, rating);
	}
}
