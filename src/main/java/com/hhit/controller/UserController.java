package com.hhit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hhit.pojo.User;
import com.hhit.pojo.Video;
import com.hhit.service.ListUserService;
import com.hhit.service.ListVideoService;
import com.hhit.service.LoginService;
import com.hhit.service.RegisterService;
import com.hhit.service.impl.ListUserServiceImpl;
import com.hhit.service.impl.ListVideoServiceImpl;
import com.hhit.service.impl.LoginServiceImpl;
import com.hhit.service.impl.RegisterServiceImpl;

@Controller
public class UserController {

	@RequestMapping(value = "/register.do")
	public void register(@RequestParam("userName") String userName, @RequestParam("pwd") String pwd,
			@RequestParam("radio") String radiovalue, HttpServletRequest req, HttpServletResponse resp) {
		RegisterService rs = new RegisterServiceImpl();
		ListUserService ls = new ListUserServiceImpl();
		int id = ls.getAllUser().size();
		int type = 0;
		try {
			radiovalue = new String(radiovalue.getBytes("ISO-8859-1"), "UTF-8");
			userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (radiovalue.equals("老师")) {
			type = 1;
		}
		rs.Register(id, userName, pwd, type);
	}

	@RequestMapping(value = "/login.do")
	public void login(@RequestParam("userId") int userId, @RequestParam("password") String password, Writer writer,
			HttpServletResponse resp, HttpServletRequest req) {
		LoginService ls = new LoginServiceImpl();
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		User user = ls.getUserById(userId);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				try {
					resp.sendRedirect("media_upload.html");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					PrintWriter out;
					out = resp.getWriter();
					out.println("wrong password");
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			try {
				resp.getWriter().write("no such user");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
