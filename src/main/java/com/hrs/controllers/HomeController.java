package com.hrs.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrs.dao.AmenityDao;
import com.hrs.dao.BookingDao;
import com.hrs.dao.RoomDao;
import com.hrs.dao.RoomTypeDao;
import com.hrs.models.Amenity;
import com.hrs.models.Booking;
import com.hrs.models.Customer;
import com.hrs.models.Room;
import com.hrs.models.RoomCriteria;
import com.hrs.models.RoomType;
import com.hrs.service.HomeService;

@Controller
public class HomeController {
	
	@Autowired
	RoomTypeDao rtDao; 
	@Autowired
	RoomDao rDao; 
	@Autowired
	BookingDao bDao; 
	@Autowired
	AmenityDao aDao; 
	@Autowired
	HomeService homeService; 

	/* Serves Main Page view */
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHome(HttpServletRequest request, HttpServletResponse response) throws IOException {		
		
		Customer currentUser = (Customer) request.getSession().getAttribute("currentUser");
		Boolean loggedIn = false;
		
		try {
			loggedIn = (boolean) request.getSession().getAttribute("authenticated");
		} catch(NullPointerException npe){ }
		
		if(loggedIn){
			if(homeService.UserCanRateHotel(currentUser)){
				request.getSession().setAttribute("canRateHotel", true);
			} 
		}
		
		Double ourRating = homeService.getAverageRating();
 		request.setAttribute("ourRating", ourRating);
		return "home";
	}
	
	/* Begin: Create booking form with dynamically selected options */
	@RequestMapping(value="/setupRT", method=RequestMethod.GET)
	public void getRoomTypes(HttpServletRequest request, HttpServletResponse response) throws IOException {		
		
        HashMap<Integer, String> rtNames = homeService.getRoomTypes(); 
        
		ObjectMapper mapper = new ObjectMapper();
		String johnJSON = mapper.writeValueAsString(rtNames);
		
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.write(johnJSON);
		
	}
	
	@RequestMapping(value="/setupCap", method=RequestMethod.GET)
	public void getCapacity(HttpServletRequest request, HttpServletResponse response) throws IOException {		
		
		System.out.println("GET RoomCapacity");
		
        List<Integer> caps = rtDao.getAllRoomCaps(); 
 
        System.out.println(caps);
		
        
		ObjectMapper mapper = new ObjectMapper();
		String johnJSON = mapper.writeValueAsString(caps);
		
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.write(johnJSON);
	
	}
	
	@RequestMapping(value="/setupMinP", method=RequestMethod.GET)
	public void getMinPrice(HttpServletRequest request, HttpServletResponse response) throws IOException {		
		
		System.out.println("GET RoomsByCriteria");

		
        Double min = rtDao.getMinPrice();
 
        System.out.println(min);
		
        
		ObjectMapper mapper = new ObjectMapper();
		String johnJSON = mapper.writeValueAsString(min);
		
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.write(johnJSON);
		
	}
	
	@RequestMapping(value="/setupMaxP", method=RequestMethod.GET)
	public void getMaxPrice(HttpServletRequest request, HttpServletResponse response) throws IOException {		
		
		List<Room> matches = new ArrayList<>(rDao.getAllRoom());
			
		Double max = rtDao.getMaxPrice();		
        
		ObjectMapper mapper = new ObjectMapper();
		String johnJSON = mapper.writeValueAsString(max);
		
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.write(johnJSON);
		
	}
	
	@RequestMapping(value="/setupAmns", method=RequestMethod.GET)
	public void getAmenities(HttpServletRequest request, HttpServletResponse response) throws IOException {		
		
		System.out.println("GET Amenities");
		
		 List<Amenity> amns = aDao.getAllAmenity();
	     HashMap<Integer, String> amenities =  new HashMap<>();
	        
	        for(Amenity a : amns){
	           amenities.put(a.getId(), a.getType());
	        }

			
			ObjectMapper mapper = new ObjectMapper();
			String johnJSON = mapper.writeValueAsString(amenities);
			
			response.setContentType("application/json");
			
			PrintWriter out = response.getWriter();
			out.write(johnJSON);
			
		
	}
	/* End: Create booking form with dynamic views */
	
	@RequestMapping(value="/rByType", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
	public String getRoomsByType(@RequestBody RoomCriteria rc, HttpServletRequest request, HttpServletResponse response) throws IOException {		
		System.out.println("GET RoomsByCriteria");

		
		//get all rooms, then intersect with match criteria
		List<Room> matchRooms = rDao.getAllRoom(); 

		
        if(!rc.getCapacity().equals("0")){
        	List<Room> filterResults = rDao.getRoomByCap(Integer.valueOf(rc.getCapacity()));
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

        	for(Room r : matchRooms) {
    			System.out.println(r);
    		}
  	
        }
        
        if(!rc.getMaxPrice().equals("0")){
        	System.out.println("!!!!!!!!!!!!!!changed max price!!!!!!!!!!!!!!!!!!!!!!!");
        	List<Room> filterResults = rDao.getRoomByPrice(Double.valueOf(rc.getMaxPrice()));
        	List<Room> toRemove = new ArrayList<Room>();
        	// Attempting to delete while in for loop..
        	for(Room rs : matchRooms){
        		int found = 0; 
        		Integer rsId = rs.getId();
        		for(Room fr : filterResults){
        			if(fr.getId() == rsId){
        				System.out.println("Should print out 6 times");
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
        if(!rc.getRoomtype().equals("0")){
        	System.out.println("!!!!!!!!!!!!!!changed room type!!!!!!!!!!!!!!!!!!!!!!");
        	List<Room> filterResults = rDao.getRoomByType(Integer.valueOf(rc.getRoomtype()));
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
        if((!rc.getCheckIn().equals("0"))&&(!rc.getNights().equals("0"))){

        	System.out.println("!!!!!!!!!!!!!!changed night and checkin!!!!!!!!!!!!!!!!!!!!!!");
        	List<Room> filterResults = rDao.getRoomByAvailabilityReplace(rc.getCheckIn(), Integer.valueOf(rc.getNights()));
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
  
        HashMap<RoomType, Integer> roomCount = roomCountByType(matchRooms);
		
        System.out.println(roomCount.size());
        
        for(int i = 0; i < roomCount.size(); i++){
        	System.out.println(roomCount.values());
        }
        if(roomCount.size() == 0){
        	roomCount = null;
        }
        //Passing object via JSON
		ObjectMapper mapper = new ObjectMapper();
		String roomsJSON = mapper.writeValueAsString(roomCount);
		
		response.setContentType("application/json");
		
		PrintWriter out = response.getWriter();
		out.write(roomsJSON);
		
		
		return null;
	}
	
	public HashMap<RoomType, Integer> roomCountByType(List<Room> rooms){
		
		HashMap<RoomType, Integer> roomCount = new HashMap<>();
		
		for(Room room : rooms){		
			Integer typeId = room.getType().getId();
			
			//changed! HashMap.replace() is not supported in Java 7. 
			if(roomCount.containsKey(room.getType())){
				Integer i = roomCount.get(room.getType()) + 1;
				roomCount.remove(room.getType());
				roomCount.put(room.getType(), i);
			}
		    else
		    	roomCount.put(room.getType(), 1);		
		}
	
		return roomCount;
	}
	
}
