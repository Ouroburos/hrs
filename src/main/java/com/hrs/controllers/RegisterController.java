package com.hrs.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrs.models.Customer;
import com.hrs.service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	RegisterService registerService;

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String getRegisterPage(ModelMap modelMap) {
		
		Customer emptyCustomer = new Customer();
		modelMap.addAttribute("customer", emptyCustomer);
		
		return "register";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String ProcessRegistration(@Valid Customer customer, BindingResult bindingResult, ModelMap modelMap, HttpServletRequest request) {
		
		if(bindingResult.hasErrors()){
			return "register";
		}
		
		registerService.saveNewCustomer(customer);
		request.setAttribute("newCustomerCreated", true);
		return "register";
	}

}
