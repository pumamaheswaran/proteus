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
 * A class representing a rating created by the user.
 * @author Pravin Umamaheswaran
 *
 */
@Entity
@Table
public class Rating {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ratingId;
	private float rating;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="imdbID",nullable=false)
	private Title title;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="email",nullable=false)
	private User user;
	
	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
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
