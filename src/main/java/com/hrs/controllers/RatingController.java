package com.hrs.controllers;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrs.models.Customer;
import com.hrs.models.Rating;
import com.hrs.service.RatingService;

@Controller
public class RatingController {

	@Autowired
	RatingService ratingService;
	
	@RequestMapping(value="/rating", method=RequestMethod.GET)
	public String getRatingPage(ModelMap modelMap, HttpServletRequest request){
 		return "rating";
	}
	
	@RequestMapping(value="/rating", method=RequestMethod.POST)
	public String doRating(ModelMap modelMap, HttpServletRequest request){
		String comment = request.getParameter("comment");
		String ratingStr = request.getParameter("star");
		//TODO: notify user of empty field
		if(comment.isEmpty() || ratingStr.isEmpty()){
			return "rating";
		}
		ratingService.processRating(request);
		request.setAttribute("newRatingCreated", true);
		return "rating";		
	}
	
}
