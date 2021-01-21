package com.barter.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.pojo.Announcement;
import com.barter.service.AnnouncementManagerService;

@SuppressWarnings("serial")
@WebServlet("/SelectOneAnnouncementController")
/*
 * 查询一个公告的控制层
 */

public class SelectOneAnnouncementController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		//获取发布公告Id
		int announcementId = Integer.parseInt(req.getParameter("announcementId"));
		
		System.out.println("...................");
		System.out.println(announcementId);
		System.out.println("...................");
		
		AnnouncementManagerService announcementManagerService = new AnnouncementManagerService();
		Announcement announcement = new Announcement();
		
		try {
			announcement = announcementManagerService.selectOneAnnouncementById(announcementId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(announcement!=null) {
			resp.sendRedirect("userInfoManager.jsp");
		}
		else {
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
	}
}