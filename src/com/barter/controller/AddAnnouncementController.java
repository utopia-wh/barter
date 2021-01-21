package com.barter.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.barter.service.AnnouncementManagerService;

@SuppressWarnings("serial")
@WebServlet("/AddAnnouncementController")
/*
 * 发布一个公告的控制层
 */

public class AddAnnouncementController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		//获取发布公告的管理员邮箱
		String userEmail = req.getParameter("userEmail");
		// 获取公告内容
		String announcementContent = req.getParameter("announcementContent");
		//获取当前时间为公告发布时间
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
		String announcementTime = simpleDateFormat.format(new Date());
		
		System.out.println("...................");
		System.out.println(userEmail);
		System.out.println(announcementContent);
		System.out.println(announcementTime);
		System.out.println("...................");
		
		AnnouncementManagerService announcementManagerService = new AnnouncementManagerService();
		int i = announcementManagerService.addAnnouncement(userEmail, announcementContent, announcementTime);
		
		if(i>0) {
			req.setAttribute("status", 1);
			req.getRequestDispatcher("addAnnouncement.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("status", 2);
			req.getRequestDispatcher("addAnnouncement.jsp").forward(req, resp);
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}