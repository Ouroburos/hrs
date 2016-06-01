package com.hrs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hrs.models.Rating;

@Repository
@Transactional(readOnly=true)
public class RatingDaoImpl implements RatingDao {
	
	@Autowired
	private SessionFactory mySessionFactory;
	
	@Override
	@Transactional(readOnly=false)
	public void saveRating(Rating rating) {
		mySessionFactory.getCurrentSession().save(rating);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Rating> getAllRating() {
		return mySessionFactory.getCurrentSession().createCriteria(Rating.class).list();
	}

	@Override
	public Rating getRatingById(Integer id) {
		return (Rating) mySessionFactory.getCurrentSession().get(Rating.class, id);
	}
	
}
