package io.egen.proteus.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A class representing a comment made by the user on a movie.
 * @author Pravin Umamaheswaran
 *
 */
@Entity
@Table
public class Comment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int commentId;
	private String comment;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="imdbID",nullable=false)
	private Title title;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="email",nullable=false)
	private User user;
	
		
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}		
}
