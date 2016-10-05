package com.hhit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hhit.dao.VideoDao;
import com.hhit.pojo.Video;
import com.hhit.service.ListVideoService;

public class ListVideoServiceImpl implements ListVideoService {

	@Resource
	private VideoDao dao;
	@Override
	public List<Video> getAllVideo() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		dao = context.getBean("videoDao", VideoDao.class);
		List<Video> videolist = dao.getAllVideo();
		((ConfigurableApplicationContext) context).close();
		return videolist;
	}

}
