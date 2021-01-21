package com.barter.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.pojo.Announcement;
import com.barter.service.AnnouncementManagerService;

@SuppressWarnings("serial")
@WebServlet("/SelectAllAnnouncementController")
/*
 * 查询所有公告的控制层
 */

public class SelectAllAnnouncementController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		
		AnnouncementManagerService announcementManagerService = new AnnouncementManagerService();
		ArrayList<Announcement> announcementList = new ArrayList<Announcement>();
		try {
			announcementList = announcementManagerService.selectAllAnnouncement();
			
			if(announcementList.size() > 0) {
				req.setAttribute("announcementList", announcementList);
				req.getRequestDispatcher("lookAnnouncement.jsp").forward(req, resp);
				
			}
			else {
				resp.sendRedirect("QueryAllGoodsByPage?goodsType=all");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}