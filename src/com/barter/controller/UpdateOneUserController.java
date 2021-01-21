package com.barter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.barter.service.UserManagerService;

@SuppressWarnings("serial")
@WebServlet("/UpdateOneUserController")
/*
 * 根据用户Id更新个人信息
 */
public class UpdateOneUserController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 防止乱码
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		// 获取用户Id
		int userId = Integer.parseInt(req.getParameter("userId"));
		// 获取修改后的用户名
		String userName = req.getParameter("userName");
		// 获取修改后的电话
		String userTelephone = req.getParameter("userTelephone");
		// 获取修改后的地址
		String userAddress = req.getParameter("userAddress");
		System.out.println(userId);
		System.out.println(userName);
		System.out.println(userAddress);
		System.out.println(userTelephone);
		UserManagerService userManagerService = new UserManagerService();
		// 若放回的i值大于为1，证明更新成功
		int i = userManagerService.UpdateOneUserById(userId, userName, userTelephone, userAddress);
		// 备注: 进行更新后重新查询个人信息
		if (i > 0) {
			req.setAttribute("updateInfoStatus", 1);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else {
			req.setAttribute("updateInfoStatus", 2);
			req.getRequestDispatcher("QueryAllGoodsByPage?goodsType=all").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
