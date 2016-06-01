package com.hrs.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrs.dao.BookingDao;
import com.hrs.dao.RatingDao;
import com.hrs.models.Booking;
import com.hrs.models.Customer;
import com.hrs.models.Rating;

@Service
public class HomeService {

		@Autowired
		BookingDao bdao;
		
		@Autowired
		RatingDao rdao;
		
		public boolean UserCanRateHotel(Customer currentUser){
			boolean allowedToRate = false;
			List<Booking> currentUserBooking = bdao.getAllByCustomerId(currentUser.getId());
			java.util.Date date= new java.util.Date();
			Timestamp now = new Timestamp(date.getTime());	
			
			for(Booking booking: currentUserBooking){
				if(now.after(booking.getCheckIn())){
					allowedToRate = true;
					break;
				}
			}
			return allowedToRate;
		}
		
		public Double getAverageRating(){
			return Math.round(averageRating(rdao.getAllRating())*100)/100.0;
		}
		
		private Double averageRating(List<Rating> ratings){
			Double sum = 0.0;
			if(!ratings.isEmpty()){
				for(Rating r: ratings){
					sum += r.getStars();
				}
				return sum.doubleValue() / ratings.size();
			}
			return sum;
		}
		
}
