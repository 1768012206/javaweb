package com.hhit.service.impl;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hhit.dao.UserDao;
import com.hhit.service.RegisterService;

public class RegisterServiceImpl implements RegisterService{

	@Resource
	UserDao dao;
	@Override
	public void Register(int id, String name, String password, int type) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		dao = context.getBean("userDao", UserDao.class);
		dao.insertUser(id, name, password, type);
		((ConfigurableApplicationContext) context).close();
	}

}
