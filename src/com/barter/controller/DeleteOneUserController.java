package com.barter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.service.UserManagerService;

@SuppressWarnings("serial")
@WebServlet("/DeleteOneUserController")
/*
 * 删除一个用户的控制层
 */
public class DeleteOneUserController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		//获取用户Id
		int userId = Integer.parseInt(req.getParameter("userId"));
		UserManagerService userManagerService = new UserManagerService();
		//若放回的i值大于为1，证明删除成功
		int i = userManagerService.deleteOneUserById(userId);
		if(i>0) {
			req.setAttribute("status", 1);
			req.getRequestDispatcher("SelectAllUserController").forward(req, resp);
		}
		else {
			req.setAttribute("status", 2);
			req.getRequestDispatcher("SelectAllUserController").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	

}
