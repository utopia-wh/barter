package com.barter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.pojo.User;
import com.barter.service.CollectManagerService;

@SuppressWarnings("serial")
@WebServlet("/DeleteOneCollectController")
/*
 * 删除一个收藏的控制层
 */
public class DeleteOneCollectController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		//获取收藏Id
		int collectId = Integer.parseInt(req.getParameter("collectId"));
		CollectManagerService collectManagerService = new CollectManagerService();
		
		System.out.println("获取session中的值");
		User user = (User) req.getSession().getAttribute("user");
		System.out.println(user.getUserEmail());
		//若放回的i值大于为1，证明删除收藏成功
		int i = collectManagerService.deleteOneCollectById(collectId);
		
		if(i>0) {
			req.setAttribute("status", 1);
			req.getRequestDispatcher("SelectAllCollectController?userId="+user.getUserId()).forward(req, resp);
		}
		
		else {
			req.setAttribute("status", 2);
			req.getRequestDispatcher("SelectAllCollectController?userId="+user.getUserId()).forward(req, resp);
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	

}
