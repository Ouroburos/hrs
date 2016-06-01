package com.hrs.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hrs.models.Customer;

public interface CustomerDao {
	void saveCustomer(Customer customer);
	List<Customer> getAllCustomer();
	Customer getCustomerById(Integer id);
	Customer getCustomerByUsername(String username);
}
