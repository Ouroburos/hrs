package com.hrs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrs.dao.BookingDao;
import com.hrs.models.Booking;

@Service
public class BookingService {
	
	@Autowired
	BookingDao dao;
	
	public List<Booking> getCurrentCustomerBooking(Integer id){
		return dao.getAllByCustomerId(id);
	}

	public boolean saveBooking(Booking booking){
		return dao.saveBooking(booking);
	}
}
