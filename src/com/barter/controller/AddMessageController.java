package com.barter.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.pojo.User;
import com.barter.service.MessageManagerService;
import com.barter.service.UserManagerService;

@SuppressWarnings("serial")
@WebServlet("/AddMessageController")
/*
 * 发送一个消息的控制层
 */

public class AddMessageController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		//获取消息发送者邮箱
		String messageSenderEmail = req.getParameter("messageSenderEmail");
		//判断用户是否登录
		if(messageSenderEmail.equals("")) {
			req.setAttribute("messageStatus", 1);
			req.getRequestDispatcher("sendMessge.jsp").forward(req, resp);
			return;
		}
		//获取消息接受者邮箱
		String messageReceiverEmail = req.getParameter("messageReceiverEmail");
		//给自己发消息不允许
		if(messageSenderEmail.equals(messageReceiverEmail)) {
			System.out.println("是否判断了是同一个人");
			req.setAttribute("messageStatus", 2);
			req.getRequestDispatcher("sendMessge.jsp").forward(req, resp);
			return;
		}
		/*
		 * 判断消息接收者是否存在
		 */
		try {
			System.out.println("是否判断接受者存在");
			UserManagerService usermanagerService = new UserManagerService();
			User user = new User();
			user = usermanagerService.selectOneUserByEmail(messageReceiverEmail);
			System.out.println(user);
			if(user==null) {
				req.setAttribute("messageStatus", 3);
				req.getRequestDispatcher("sendMessge.jsp").forward(req, resp);
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 获取消息内容
		String messageContent = req.getParameter("messageContent");
		//获取当前时间为消息发送时间
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
		String messageTime = simpleDateFormat.format(new Date());
		
		System.out.println("...................");
		System.out.println(messageSenderEmail);
		System.out.println(messageReceiverEmail);
		System.out.println(messageContent);
		System.out.println(messageTime);
		System.out.println("...................");
		
		MessageManagerService messageManagerService = new MessageManagerService();
		int i = messageManagerService.addAnnouncement(messageSenderEmail, messageReceiverEmail, messageContent, messageTime);
		//若消息发送成功，返回首页界面并提示
		if(i>0) {
			req.setAttribute("messageStatus", 4);
			req.getRequestDispatcher("sendMessge.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("messageStatus", 5);
			req.getRequestDispatcher("sendMessge.jsp").forward(req, resp);
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}