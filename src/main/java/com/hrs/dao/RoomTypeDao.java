package com.hrs.dao;

import java.util.List;

import com.hrs.models.RoomType;

public interface RoomTypeDao {
	List<RoomType> getAllRoomType();
	RoomType getRoomTypeById(Integer id);
	List<Integer> getAllRoomCaps();
	Double getMaxPrice();
	Double getMinPrice();
}
