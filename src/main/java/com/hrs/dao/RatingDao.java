package com.hrs.dao;

import java.util.List;

import com.hrs.models.Rating;

public interface RatingDao {
	void saveRating(Rating rating);
	List<Rating> getAllRating();
	Rating getRatingById(Integer id);
}
