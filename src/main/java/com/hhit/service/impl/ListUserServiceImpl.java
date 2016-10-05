package com.hhit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hhit.dao.UserDao;
import com.hhit.pojo.User;
import com.hhit.service.ListUserService;

public class ListUserServiceImpl implements ListUserService {

	@Resource
	private UserDao dao;
	@Override
	public List<User> getAllUser() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		dao = context.getBean("userDao", UserDao.class);
		List<User> userlist = dao.getAllUser();
		((ConfigurableApplicationContext) context).close();
		return userlist;
	}

}
