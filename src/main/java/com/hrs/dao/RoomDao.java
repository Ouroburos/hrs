package com.hrs.dao;

import java.util.HashSet;
import java.util.List;

import org.hibernate.criterion.Criterion;

import com.hrs.models.Room;

public interface RoomDao {
	void saveRoom(Room room);
	List<Room> getAllRoom();
	Room getRoomById(Integer id);
	List<Room> getRoomByType(Integer tid);
	List<Room> getRoomByPrice(Double price);
	List<Room> getRoomByCap(Integer cap);
	List<Room> getRoomByAvailabilityReplace(String checkIn, Integer nights);
    List<Room> getRoomsbyCriteria(List<Criterion> criterion);
}
