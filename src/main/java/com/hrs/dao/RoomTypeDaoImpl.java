package com.hrs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hrs.models.RoomType;

@Component
@Transactional
public class RoomTypeDaoImpl implements RoomTypeDao {
	
	@Autowired
	private SessionFactory mySessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<RoomType> getAllRoomType() {
		
		String hql = "from RoomType";
		return mySessionFactory.getCurrentSession().createQuery(hql).list();
	   
	}
	
	@Override
	public RoomType getRoomTypeById(Integer id) {
		return (RoomType) mySessionFactory.getCurrentSession().get(RoomType.class, id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getAllRoomCaps() {
		
		String hql = "select distinct capacity from RoomType";
		return mySessionFactory.getCurrentSession().createQuery(hql).list();
	   
	}
	
	@Override
	public Double getMinPrice() {
		
		String hql = "select min(price) from RoomType";
		return (Double) mySessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
	   
	}
	
	@Override
	public Double getMaxPrice() {
		
		String hql = "select max(price) from RoomType";
		return (Double) mySessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
	   
	}
}
