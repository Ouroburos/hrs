package com.hrs.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hrs.models.Customer;

@Component
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory mySessionFactory;

	@Override
	public void saveCustomer(Customer customer) {
		mySessionFactory.getCurrentSession().save(customer);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomer() {
//		return sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
		Session session = mySessionFactory.getCurrentSession();
		List<Customer> cl = session.createCriteria(Customer.class).list();
		return cl;
	}

	@Override
	public Customer getCustomerById(Integer id) {
		return (Customer) mySessionFactory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Customer getCustomerByUsername(String username) {
		Session session = mySessionFactory.getCurrentSession();
		String hql = "select customer from Customer c where c.username = :username";
		// Customer c = (Customer) session.createQuery(hql)
		// .setString("username", username).list().get(0);

		List<Customer> cl;
//		Query q = (Query) session.createQuery(hql);
//		List<Customer> cl = q.setString("username", username).list();
//		Customer c = cl.get(0);
//
//		return c;
//		
//		cl = sessionFactory.getCurrentSession().createCriteria(Customer.class)
//				.add(Restrictions.eq("username", username)).list();
//
//		if(cl.isEmpty()){
//			return null;
//		}
//		return cl.get(0);
		return null;
	}


}
