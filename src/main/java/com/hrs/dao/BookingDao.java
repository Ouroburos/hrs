package com.hrs.dao;

import java.util.List;

import com.hrs.models.Booking;

public interface BookingDao {
	boolean saveBooking(Booking booking);
	List<Booking> getAllBooking();
	Booking getBookingById(Integer id);
	List<Booking> getAllByCustomerId(Integer id);
}
