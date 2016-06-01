package com.hrs.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class LogoutService {

	public void inValidateLogin(HttpServletRequest req) {
		req.getSession().invalidate();
	}
	
}
