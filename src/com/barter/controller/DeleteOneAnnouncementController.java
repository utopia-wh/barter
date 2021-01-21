package com.barter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.barter.service.AnnouncementManagerService;

@SuppressWarnings("serial")
@WebServlet("/DeleteOneAnnouncementController")
/*
 * 删除一个公告的控制层
 */
public class DeleteOneAnnouncementController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		//获取公告Id
		int announcementId = Integer.parseInt(req.getParameter("announcementId"));
		AnnouncementManagerService announcementManagerService = new AnnouncementManagerService();
		//若放回的i值大于为1，证明删除公告成功
		int i = announcementManagerService.deleteOneAnnouncementById(announcementId);
		
		if(i>0) {
			req.setAttribute("status", 1);
			req.getRequestDispatcher("SelectAllAnnouncementController").forward(req, resp);
		}
		else {
			req.setAttribute("status", 2);
			req.getRequestDispatcher("SelectAllAnnouncementController").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	

}
