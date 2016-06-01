package com.hrs.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hrs.models.Room;

@Component
@Transactional
public class RoomDaoImpl implements RoomDao {

	@Autowired
	private SessionFactory mySessionFactory;

	@Override
	public void saveRoom(Room room) {
		mySessionFactory.getCurrentSession().save(room);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> getAllRoom() {
		Session s = mySessionFactory.getCurrentSession();
		String hql = "from Room";
		return s.createQuery(hql).list();
	}

	@Override
	public Room getRoomById(Integer id) {
		return (Room) mySessionFactory.getCurrentSession().get(Room.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Room> getRoomByType(Integer tid) {
		Session s = mySessionFactory.getCurrentSession();
		String hql = "from Room where type.id = :tid";
		Query query = s.createQuery(hql);
		query.setParameter("tid",tid);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Room> getRoomByCap(Integer cap) {
		Session s = mySessionFactory.getCurrentSession();
		String hql = "from Room where type.capacity = :cap";
		Query query = s.createQuery(hql);
		query.setParameter("cap",cap);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Room> getRoomByPrice(Double price) {
		Session s = mySessionFactory.getCurrentSession();
		String hql = "from Room where type.price <= :p";
		Query query = s.createQuery(hql);
		query.setParameter("p", price);
		return query.list();
	}
 	
	@SuppressWarnings("unchecked")
	@Override
	public List<Room> getRoomByAvailabilityReplace(String checkIn, Integer nights) {
		System.out.println("in get room by date yo");
		Session s = mySessionFactory.getCurrentSession();
		String hql = "select R from Room R left join R.bookings B where :date < B.checkIn or :date >= B.checkOut or B.id is null";
		Query query = s.createQuery(hql);
		Timestamp date = Timestamp.valueOf(checkIn+" 00:00:00");
		HashSet<Room> r = new HashSet<>();
		r.addAll(query.setParameter("date", date).list());
		System.out.println("size after adding.."+r.size());
		int nextDay = 0;
			
		while(nights > 0){ //run query for each night of stay
		  nextDay += 24;
		  date = Timestamp.valueOf(checkIn+" "+nextDay+":00:00");
		  System.out.println(date);
		  r.retainAll(query.setParameter("date", date).list());
		  System.out.println("size after retaining.."+r.size());
 		  nights--;
		}
		
		return new ArrayList<Room>(r);
	}
	
	//Taylor's Criteria example
	@SuppressWarnings("unchecked")
	public List<Room> getRoomsbyCriteria(List<Criterion> criterion){	
		
		Criteria criteria = mySessionFactory.getCurrentSession().createCriteria(Room.class);
		         criteria.createAlias("type", "t");
		         criteria.createAlias("bookings", "b");
		
		for(Criterion rstric : criterion){
			criteria.add(rstric); 
		}
		
		return criteria.list();
				
	}
}
