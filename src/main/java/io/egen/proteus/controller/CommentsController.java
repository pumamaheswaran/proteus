package io.egen.proteus.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.proteus.entity.Comment;
import io.egen.proteus.exception.TitleNotFoundException;
import io.egen.proteus.service.CommentServiceImpl;
import io.jsonwebtoken.Claims;
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
public class CommentsController {
	
	@Autowired
	private CommentServiceImpl service;
	
	
	@RequestMapping(value="{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST)
	@ApiOperation(value="Register a comment",notes="Returns the registered comment")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404,message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})
	public Comment registerComment(HttpServletRequest request, @PathVariable("id") String imdbId, @RequestBody Comment comment) throws TitleNotFoundException {
		Claims claims = (Claims) request.getAttribute("claims");
		return service.registerComment(claims.getSubject(), imdbId, comment);
	}
	
	@RequestMapping(value="{id}",produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.GET)
	@ApiOperation(value="Find comments related to a title",notes="Returns a list of comments")
	@ApiResponses(value={
			@ApiResponse(code=200, message="Success"),
			@ApiResponse(code=404, message="Not found"),
			@ApiResponse(code=500, message="Internal Server Error")
	})	
	public Set<Comment> getComments(@PathVariable("id") String imdbId) throws TitleNotFoundException {
		return service.getComments(imdbId);
	}
}
