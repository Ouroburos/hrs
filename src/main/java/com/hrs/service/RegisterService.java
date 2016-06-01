package com.hrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrs.dao.CustomerDao;
import com.hrs.models.Customer;

@Service
@Transactional
public class RegisterService {
	
	@Autowired
	CustomerDao dao;

	public void saveNewCustomer(Customer customer) {
		dao.saveCustomer(customer);
	}
	
}
