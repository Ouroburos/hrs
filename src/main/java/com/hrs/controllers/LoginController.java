package com.hrs.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrs.dao.BookingDao;
import com.hrs.models.Customer;
import com.hrs.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private BookingDao bdao;
	
	public LoginController(){}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String getLoginPage(ModelMap modelMap, HttpServletRequest request){
		Customer emptyUser = new Customer();
		modelMap.addAttribute("customer", emptyUser);
		modelMap.addAttribute("authenticated", false);
		return "login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String doLogin(@Valid Customer customer, BindingResult bindingResult, ModelMap modelMap, HttpServletRequest request){
//		if(bindingResult.hasErrors()){
//			//ASSERT: validation failed
//			System.out.println("login control - ERRORS 1"+bindingResult.toString());
//			return "login";
//		}
		
		//ASSERT: validation successful
		Customer authorizedUser = loginService.validateLogin(customer);
		request.getSession().setAttribute("authenticated", false);
		if(authorizedUser != null){
			//ASSERT: authentication successful
			authorizedUser.setReservations(bdao.getAllByCustomerId(authorizedUser.getId()));
			request.getSession().setAttribute("authenticated", true); //they have been authenticated
			request.getSession().setAttribute("currentUser", authorizedUser);
			
			return "redirect:home";
		} else {
			//ASSERT: authentication failed
			modelMap.addAttribute("errorMessage", "Username/Password incorrect");
			return "login";	
		}
	}
}