package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.User;
import com.springmvc.service.userService;
@Controller
public class registerController {
	
	@Autowired
	public userService userservice;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public ModelAndView doRegister(HttpServletRequest request, HttpServletResponse response)
	{
		
		//String name=request.getParameter("nm");
		ModelAndView mv=new ModelAndView("register");
		//mv.setViewName("display.jsp");
		//return "display.jsp";
		mv.addObject("user", new User());
		return mv;
	}
	
	
	@RequestMapping(value="/registerProcess",method=RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user )
	{
		userservice.register(user);
//		String name=request.getParameter("nm");
//		ModelAndView mv=new ModelAndView("register");
//		mv.setViewName("display.jsp");
		return new ModelAndView("welcome");
	}

}
