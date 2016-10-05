package com.hhit.service.impl;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hhit.dao.VideoDao;
import com.hhit.service.UploadService;

public class UploadServiceImpl implements UploadService{

	@Resource
	VideoDao dao;
	
	@Override
	public void saveToDataBase(int id, String name, String path) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		dao = context.getBean("videoDao", VideoDao.class);
		dao.insertVideo(id, name, path);
		((ConfigurableApplicationContext) context).close();
	}

}
