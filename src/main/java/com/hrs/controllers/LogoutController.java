package com.hrs.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrs.service.LogoutService;

@Controller
public class LogoutController {

	@Autowired
	private LogoutService logoutService;
	
	public LogoutController(){}
	
	@RequestMapping(value="/logout")
	public String logout(ModelMap modelMap, HttpServletRequest request,HttpServletResponse response) throws IOException{
		logoutService.inValidateLogin(request);
		return "redirect:home";
	}
	
}
