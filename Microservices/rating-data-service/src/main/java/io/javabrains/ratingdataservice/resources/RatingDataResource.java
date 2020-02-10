package io.javabrains.ratingdataservice.resources;

import java.util.Arrays;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.ratingdataservice.model.Rating;
import io.javabrains.ratingdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		UserRating userRating = new UserRating();
		 userRating.setUserRating(Arrays.asList(new Rating("1234", 4),new Rating("4567", 3)));
		 return userRating;
	}

}
