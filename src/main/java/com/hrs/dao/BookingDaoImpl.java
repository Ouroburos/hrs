package com.hrs.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hrs.models.Booking;

@Repository
@Transactional
public class BookingDaoImpl implements BookingDao {

	@Autowired
	private SessionFactory mySessionFactory;
	
	public boolean saveBooking(Booking booking){
		Integer genId = (Integer) mySessionFactory.getCurrentSession().save(booking);
		return (genId > 0) ? true : false; 
			
	}
	
	@Override	
	@SuppressWarnings("unchecked")
	public List<Booking> getAllBooking() {
		return mySessionFactory.getCurrentSession().createCriteria(Booking.class).list();
	}

	@Override
	public Booking getBookingById(Integer id) {
		return (Booking) mySessionFactory.getCurrentSession().get(Booking.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Booking> getAllByCustomerId(Integer id) {
//		 return (List<Booking>) mySessionFactory.getCurrentSession()
//				 .createCriteria(Customer.class)
//				 .add(Restrictions.eq("guest.id", id))
//				 .list();
		List<Booking> bookings = null;
		Session session = mySessionFactory.getCurrentSession();
		String hql = "from Booking b where b.guest.id = :id";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		bookings = query.list();
		return bookings;
	}
	
}
