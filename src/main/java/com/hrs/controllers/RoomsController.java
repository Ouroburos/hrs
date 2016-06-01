package com.hrs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrs.dao.CustomerDao;
import com.hrs.dao.CustomerDaoImpl;
import com.hrs.dao.RoomDao;
import com.hrs.dao.RoomDaoImpl;
import com.hrs.models.Customer;
import com.hrs.models.Room;

@Controller
public class RoomsController {
    
	@Autowired
	RoomDao rDao; 
	
	
	@RequestMapping(value="/rooms", method=RequestMethod.GET)
	public String getRooms(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap){
		List<Room>rooms = rDao.getAllRoom(); 
		modelMap.addAttribute("Rooms", rooms); 
		return "rooms";
	}
	
}