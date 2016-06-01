package com.hrs.dao;

import java.util.List;

import com.hrs.models.Amenity;
import com.hrs.models.Customer;

public interface AmenityDao {
	List<Amenity> getAllAmenity();
	Amenity getAmenityById(Integer id);
}
