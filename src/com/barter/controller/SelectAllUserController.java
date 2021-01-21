package com.barter.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.pojo.User;
import com.barter.service.UserManagerService;

@SuppressWarnings("serial")
@WebServlet("/SelectAllUserController")
/*
 * 查询所有用户控制层
 */
public class SelectAllUserController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		UserManagerService userManagerService = new UserManagerService();
		try {
			ArrayList<User> userList = userManagerService.selectAllUser();
			if(userList.size()>0) {
				req.setAttribute("userList", userList);
				req.getRequestDispatcher("userManager.jsp").forward(req, resp);
			}
			else {
				resp.sendRedirect("noGoods.jsp");
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
