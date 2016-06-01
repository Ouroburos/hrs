 package com.hrs.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrs.dao.RatingDao;
import com.hrs.models.Customer;
import com.hrs.models.Rating;

@Service
public class RatingService {
	
	@Autowired
	private RatingDao dao;
	
	public void processRating(HttpServletRequest request){
		
		String comment = request.getParameter("comment");
		String ratingStr = request.getParameter("star");
		Integer ratingVal = 0;
		
		try {
			ratingVal = Integer.parseInt(ratingStr);
		} catch(NumberFormatException e){
//			  return "rating";
		}

		Customer currentUser = (Customer) request.getSession().getAttribute("currentUser");
		java.util.Date date = new java.util.Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		
		Rating rating = new Rating(currentUser, ratingVal, comment, timeStamp, true);
		dao.saveRating(rating);
	}
}
