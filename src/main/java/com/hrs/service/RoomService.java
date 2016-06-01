package com.hrs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrs.dao.RoomDao;
import com.hrs.models.Room;

@Service
public class RoomService {

	@Autowired
	RoomDao dao;
	
	public List<Room> getAllRooms(){
		return dao.getAllRoom();
	}
}
