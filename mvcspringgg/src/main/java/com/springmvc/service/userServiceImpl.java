package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.userDao;
import com.springmvc.model.Login;
import com.springmvc.model.User;

public class userServiceImpl implements userService {
	@Autowired
	userDao userdao;
	public void register(User user)
	{
		userdao.register(user);
	}
//	public User validateUser(Login login)
//	{
//		return userdao.validateUser(login);
//	}
	public User validateUser(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

}
