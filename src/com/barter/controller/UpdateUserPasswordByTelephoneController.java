package com.barter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.barter.service.UserManagerService;

@SuppressWarnings("serial")
@WebServlet("/UpdateUserPasswordByTelephoneController")
/*
 * 根据用户Id更新个人信息
 */
public class UpdateUserPasswordByTelephoneController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//防止乱码
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		//获取用户电话，根据用户电话号码修改密码
		String userTelephone = req.getParameter("userTelephone");
		//获取修改后的用户密码
		String userPassword = req.getParameter("userPassword");
		System.out.println(userPassword);
		System.out.println(userTelephone);
		UserManagerService userManagerService = new UserManagerService();
		//若放回的i值大于为1，证明更新成功
		int i = userManagerService.UpdateUserPasswordByTelephone(userPassword, userTelephone);
		//备注: 密码修改后跳转到登录界面
		if(i>0) {
			req.setAttribute("updatePS", 1);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("updatePS", 2);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	

}
