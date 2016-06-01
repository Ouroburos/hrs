package com.hrs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrs.dao.CustomerDao;
import com.hrs.models.Customer;

@Service
@Transactional
public class LoginService {

	@Autowired
	CustomerDao dao;

	public Customer validateLogin(Customer customer) {
		Customer validCustomer = null;

//		 Customer user = dao.getCustomerByUsername(customer.getUsername());

		// if(user != null){
		// if(user.getUsername().equals(customer.getUsername())
		// && user.getPassword().equals(customer.getPassword())){
		// validCustomer = user;
		// }
		// }
		List<Customer> cl = dao.getAllCustomer();
		Customer user = null;
		for (Customer c : cl) {
			if (customer.getUsername().equalsIgnoreCase(c.getUsername())) {
				user = c;
			}
		}

		if (user != null) {
			if (user.getUsername().equals(customer.getUsername())
					&& user.getPassword().equals(customer.getPassword())) {
				validCustomer = user;
			}
		}

		return validCustomer;
	}
}
