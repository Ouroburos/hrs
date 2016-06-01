package com.hrs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hrs.models.Amenity;

@Component
@Transactional
public class AmenityDaoImpl implements AmenityDao {

	@Autowired
	private SessionFactory mySessionFactory;
	
	@Override	
	@SuppressWarnings("unchecked")
	public List<Amenity> getAllAmenity() {
	  return mySessionFactory.getCurrentSession().createCriteria(Amenity.class).list();
	}

	@Override
	public Amenity getAmenityById(Integer id) {
		return (Amenity) mySessionFactory.getCurrentSession().get(Amenity.class, id);
	}

}
