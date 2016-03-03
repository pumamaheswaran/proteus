package io.egen.proteus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.proteus.entity.Comment;
import io.egen.proteus.exception.TitleNotFoundException;
import io.egen.proteus.service.CommentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Controller for all comments related operations.
 * @author Pravin Umamaheswaran
 *
 */
@RestController
@RequestMapping("/api/comments")
@Api(tags="comments")
public class CommentsController {
	
	@Autowired
	private CommentServiceImpl service;
	
	
	@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	@ApiOperation(value="Register a comment",notes="Does not have a return value")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404,message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public void registerComment(Comment comment) throws TitleNotFoundException {
		service.registerComment(comment);
	}
	
	@RequestMapping(consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	@ApiOperation(value="Find comments related to a title",notes="Returns a list of comments")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})	
	public List<Comment> getComments(@PathVariable("imdbId") String imdbId) throws TitleNotFoundException {
		return service.getComments(imdbId);
	}
}
