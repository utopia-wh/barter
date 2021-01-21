package com.barter.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.barter.pojo.User;
import com.barter.service.UserManagerService;

@SuppressWarnings("serial")
@WebServlet("/VerifyEmailAndTelephoneController")

/*
 * 修改密码时验证验证手机号和邮箱
 */
public class VerifyEmailAndTelephoneController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		System.out.println("进入验证");
		String userEmail = req.getParameter("userEmail");
		String userTelephone = req.getParameter("userTelephone");
		System.out.println(userEmail+"1");
		System.out.println(userTelephone+"2");
		if ("".equals(userEmail) || "".equals(userTelephone)) {
			System.out.println("判断是否空");
			req.setAttribute("verify", 1);
			req.getRequestDispatcher("verifyEmailAndTelephone.jsp").forward(req, resp);	
		}
		User user = new User();
		UserManagerService usermanagerService = new UserManagerService();
		try {
			user = usermanagerService.selectOneUserByEmail(userEmail);
			// System.out.println("打印头像路径"+user.getUserImage());
			if (user != null) {
				System.out.println("user不为空");
				if (userTelephone.equals(user.getUserTelephone())) {
					req.setAttribute("verify", 3);
					req.setAttribute("user", user);
					req.getRequestDispatcher("updatePassword.jsp").forward(req, resp);
				} else {
					// 用户输入的手机号和数据库中的查询不一致时，跳转验证界面
					req.setAttribute("verify", 3);
					req.getRequestDispatcher("verifyEmailAndTelephone.jsp").forward(req, resp);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
