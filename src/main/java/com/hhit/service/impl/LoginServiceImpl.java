package com.hhit.service.impl;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.hhit.dao.UserDao;
import com.hhit.pojo.User;
import com.hhit.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Resource
	private UserDao dao;
	@Override
	public User getUserById(int id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		dao = context.getBean("userDao", UserDao.class);
		User user;
		try{
			user = dao.getUser(id);
		}catch (Exception e) {
			user=null;
		}
		((ConfigurableApplicationContext) context).close();
		return user;
	}
	
	
	
}
