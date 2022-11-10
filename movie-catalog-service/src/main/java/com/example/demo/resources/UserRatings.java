package com.example.demo.resources;

import java.util.List;

public class UserRatings {

	private List<Rating> userRating;

	public UserRatings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRatings(List<Rating> userRating) {
		super();
		this.userRating = userRating;
	}

	public List<Rating> getUserRating() {
		return userRating;
	}

	public List<Rating> setUserRating(List<Rating> userRating) {
		return this.userRating = userRating;
	}
}
