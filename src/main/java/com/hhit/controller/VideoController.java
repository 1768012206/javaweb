package com.hhit.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hhit.dao.VideoDao;
import com.hhit.pojo.Video;
import com.hhit.service.ListVideoService;
import com.hhit.service.UploadService;
import com.hhit.service.impl.ListVideoServiceImpl;
import com.hhit.service.impl.UploadServiceImpl;

@Controller
public class VideoController {

	@RequestMapping(value = "/upload.do")
	public void upload(@RequestParam("myvideo") MultipartFile file, @RequestParam("title") String title,
			HttpServletRequest req, HttpServletResponse resp) {
		UploadService us = new UploadServiceImpl();

		if (!file.isEmpty()) {
			String contenttype = file.getContentType();
			String type[] = contenttype.split("/");
			System.out.println(type[1]);
			if (type[1].equals("mp4") || type[1].equals("MP4") || type[1].equals("flv") || type[1].equals("pdf")) {
				try {
					req.setCharacterEncoding("utf-8");
					String filename = new String(file.getOriginalFilename().getBytes(), "UTF-8");
					String path = req.getServletContext().getRealPath("/");
					System.out.println(path);
					ListVideoService lvs = new ListVideoServiceImpl();
					List<Video> videolist = lvs.getAllVideo();
					int id = videolist.size();
					file.transferTo(new File(path + filename));
					us.saveToDataBase(id, filename, path);
					resp.getWriter().write("success");
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					resp.getWriter().write("fail");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@RequestMapping(value = "/videolist.do")
	public void getVideoList(HttpServletRequest req, HttpServletResponse resp) {
		ListVideoService lvs = new ListVideoServiceImpl();
		List<Video> videolist = lvs.getAllVideo();
		req.setAttribute("videolist", videolist);
		try {
			req.getRequestDispatcher("media_list.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
