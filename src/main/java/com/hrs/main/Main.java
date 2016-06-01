package com.hrs.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrs.dao.AmenityDao;
import com.hrs.dao.CustomerDao;
import com.hrs.dao.RoomDao;
import com.hrs.dao.RoomDaoImpl;
import com.hrs.models.Amenity;
import com.hrs.models.Customer;
import com.hrs.models.Room;

public class Main {

	public static void main(String[] args) {
//
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("WEB-INF/beans.xml");
		
		/*
		AmenityDao dao = (AmenityDao) applicationContext.getBean("amenitydao");
		List<Amenity> al = dao.getAllAmenity();
		System.out.println(dao.getAmenityById(2));
		
		for (Amenity a : al) {
			System.out.println(a);
		}
        */
		
		RoomDao rdao = applicationContext.getBean(RoomDaoImpl.class);

        Room one = rdao.getRoomById(23);
        List<Room> onlyOne = rdao.getRoomByCap(7);
        Room two = onlyOne.get(0);
        
        System.out.println("One: "+one);
        System.out.println("Two: "+two);
		

	}

}
