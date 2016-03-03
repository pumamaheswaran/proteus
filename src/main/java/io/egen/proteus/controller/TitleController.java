package io.egen.proteus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.proteus.entity.Title;
import io.egen.proteus.exception.TitleAlreadyExistsException;
import io.egen.proteus.exception.TitleNotFoundException;
import io.egen.proteus.service.TitleServiceImpl;
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
	
	/*@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	@ApiOperation(value="Rate a title",notes="Does not have a return value")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public void rateTitle(Title title) throws TitleNotFoundException {
		
	}*/
	
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
	
	@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	@ApiOperation(value="Add a new title",notes="Returns the added title")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public Title addNewTitle(@RequestBody Title title) throws TitleAlreadyExistsException {		
		return service.addNewTitle(title);
	}
	
	@RequestMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.PUT)
	@ApiOperation(value="Edit a title",notes="Returns the edited title")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public Title editTitle(@PathVariable("id") String id,@RequestBody Title title) throws TitleNotFoundException {
		return service.editTitle(title);
	}
	
	@RequestMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.DELETE)
	@ApiOperation(value="Delete an existing title",notes="Does not have a return value")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public void deleteTitle(@PathVariable("id") String id) throws TitleNotFoundException {
		service.deleteTitle(id);
	}
	
}
