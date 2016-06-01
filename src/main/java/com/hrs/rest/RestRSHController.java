package com.hrs.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hrs.models.Room;
import com.hrs.service.RoomService;

@RestController
@RequestMapping("rest/rshinfo")
public class RestRSHController {

	@Autowired
	private RoomService roomService;
	
	@RequestMapping(value="allrooms", method=RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	public List<Room> getAllRooms(){
		return (ArrayList<Room>) roomService.getAllRooms();
	} 
}
