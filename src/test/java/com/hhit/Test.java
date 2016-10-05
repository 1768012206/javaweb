package com.hhit;

import java.util.List;


import com.hhit.pojo.Video;
import com.hhit.service.ListVideoService;
import com.hhit.service.impl.ListVideoServiceImpl;

public class Test {

	public static void main(String[] args) {
		ListVideoService lvs = new ListVideoServiceImpl();
		List<Video> videolist = lvs.getAllVideo();
		for(Video video : videolist) {
			System.out.println(video.getName());
		}
	}

}
