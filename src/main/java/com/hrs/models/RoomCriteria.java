package com.hrs.models;

import java.util.List;

public class RoomCriteria {

	String roomtype;
	String maxPrice;
	String capacity;
	String checkIn;
	String nights;
	List<String> amenities;
	
	
	public RoomCriteria(){}
	
	public RoomCriteria(String roomtype, String maxPrice, String capacity, String checkIn, String nights) {
		super();
		this.roomtype = roomtype;
		this.maxPrice = maxPrice;
		this.capacity = capacity;
		this.checkIn = checkIn;
		this.nights = nights;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getNights() {
		return nights;
	}

	public void setNights(String nights) {
		this.nights = nights;
	}

	public List<String> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
	}

	@Override
	public String toString() {
		return "RoomCriteria [roomtype=" + roomtype + ", maxPrice=" + maxPrice + ", capacity=" + capacity + ", checkIn="
				+ checkIn + ", nights=" + nights + ", amenities=" + amenities + "]";
	}
	
	
}
