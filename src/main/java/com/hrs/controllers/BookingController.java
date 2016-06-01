package com.hrs.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrs.dao.AmenityDao;
import com.hrs.dao.RoomDao;
import com.hrs.models.Amenity;
import com.hrs.models.Booking;
import com.hrs.models.Customer;
import com.hrs.models.Room;
import com.hrs.service.BookingService;

@Controller
public class BookingController {

	@Autowired
	BookingService bookingService;
	@Autowired
	RoomDao rDao; 
	@Autowired
	AmenityDao aDao; 
	
	@RequestMapping(value="/booking")
	public String getReservations(HttpServletRequest request){
		Customer currentUser = (Customer) request.getSession().getAttribute("currentUser");
		return "redirect:home";		
	}
	
	
	@RequestMapping(value="/makeReservation")
	public String makeReservation(HttpServletRequest request){
        
        Customer guest = (Customer) request.getSession().getAttribute("currentUser"); 
        Timestamp checkIn = Timestamp.valueOf(request.getParameter("checkin")+" 00:00:00");
        
        int co = Integer.parseInt(request.getParameter("nights")) * 24; 
        Timestamp checkOut = Timestamp.valueOf(request.getParameter("checkin")+" "+co+":00:00");
        
        
		
      //get all rooms, then intersect with match criteria
      		List<Room> matchRooms = rDao.getAllRoom(); 

      		
              if(request.getParameter("cap") != null){
              	List<Room> filterResults = rDao.getRoomByCap(Integer.valueOf(request.getParameter("cap")));
              	List<Room> toRemove = new ArrayList<Room>();
              	// Attempting to delete while in for loop..
              	for(Room rs : matchRooms){
              		int found = 0; 
              		Integer rsId = rs.getId();
              		for(Room fr : filterResults){
              			if(fr.getId() == rsId){
              				found = 1;
              				break;
              			}
              		}
              		if(found == 0){
              		   toRemove.add(rs);
              		}
              	}   	
              	
              	matchRooms.removeAll(toRemove);
        	
              }
              
              if(request.getParameter("price") != null){
              	List<Room> filterResults = rDao.getRoomByPrice(Double.valueOf(request.getParameter("price")));
              	List<Room> toRemove = new ArrayList<Room>();
              	// Attempting to delete while in for loop..
              	for(Room rs : matchRooms){
              		int found = 0; 
              		Integer rsId = rs.getId();
              		for(Room fr : filterResults){
              			if(fr.getId() == rsId){
              				found = 1;
              				break;
              			}
              		}
              		if(found == 0){
              		   toRemove.add(rs);
              		}
              	}   	
              	
              	matchRooms.removeAll(toRemove);
              }	
              
              if(request.getParameter("roomtypes") != null){
              	List<Room> filterResults = rDao.getRoomByType(Integer.valueOf(request.getParameter("roomtypes")));
              	List<Room> toRemove = new ArrayList<Room>();
              	// Attempting to delete while in for loop..
              	for(Room rs : matchRooms){
              		int found = 0; 
              		Integer rsId = rs.getId();
              		for(Room fr : filterResults){
              			if(fr.getId() == rsId){
              				found = 1;
              				break;
              			}
              		}
              		if(found == 0){
              		   toRemove.add(rs);
              		}
              	}   	
              	
              	matchRooms.removeAll(toRemove);
              
              }

            if((request.getParameter("checkin") != null)&&(request.getParameter("nights") != null)){
          	System.out.println("!!!!!!!!!!!!!!changed night and checkin!!!!!!!!!!!!!!!!!!!!!!");
          	List<Room> filterResults = rDao.getRoomByAvailabilityReplace(request.getParameter("checkin"), Integer.valueOf(request.getParameter("nights")));
          	List<Room> toRemove = new ArrayList<Room>();
          	// Attempting to delete while in for loop..
          	for(Room rs : matchRooms){
          		int found = 0; 
          		Integer rsId = rs.getId();
          		for(Room fr : filterResults){
          			if(fr.getId() == rsId){
          				found = 1;
          				break;
          			}
          		}
          		if(found == 0){
          		   toRemove.add(rs);
          		}
          	}   	        	
          	System.out.println(toRemove.size());
          	matchRooms.removeAll(toRemove);
          	System.out.println(matchRooms.size());
          	for(Room r : matchRooms){
      			System.out.println(r);
      		}
	    }
            
        
        Booking b = new Booking();
        String message = "";
        
        String[] ams = request.getParameterValues("amenities");    
        List<Amenity> ba = new ArrayList<>();
        if(ams != null){
        for(int i = 0; i < ams.length; i++){
        	ba.add(aDao.getAmenityById(Integer.parseInt(ams[i])));
        }
        }
        
        System.out.println("HHHHHHHHHHHHHHHHHHHHHHH");
		System.out.println(guest);
		System.out.println(checkIn);
		System.out.println(checkOut);
		System.out.println(matchRooms.get(0));
		System.out.println(ba);
		System.out.println("HHHHHHHHHHHHHHHHHHHHHHH");
         
            b.setGuest(guest);
            b.setCheckIn(checkIn);
            b.setCheckOut(checkOut);
            b.setRoom(matchRooms.get(0));
            b.setAmenities(ba);
		
		if(bookingService.saveBooking(b)){
		    message = "Your booking has been processed successfully!";
		}else{
		    message = "We're sorry, there were problems booking your room at this time. Please call, or try again later.";
		}
		
		request.setAttribute("bookingMessage", message);
		
		return "home";		
	}
	
}
