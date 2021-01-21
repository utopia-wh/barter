package com.barter.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import com.barter.pojo.User;
import com.barter.service.UserManagerService;

@SuppressWarnings("serial")
@WebServlet("/SelectOneUserController")

/*
 * 查询一个用户的控制层 当使用post方法提交时,进行的登录的用户查询，根据用户邮箱查询用户是否存在
 * 当使用get方法提交时，进行的管理员和用户查看用户个人信息
 */
public class SelectOneUserController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		String userEmail = req.getParameter("userEmail");
		String userPassword = req.getParameter("userPassword");
		System.out.println(userEmail);
		System.out.println(userPassword);
		if ("".equals(userEmail) || "".equals(userPassword)) {
			req.setAttribute("loginError", 2);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		User user = new User();
		HttpSession session = req.getSession();
		UserManagerService usermanagerService = new UserManagerService();
		try {
			user = usermanagerService.selectOneUserByEmail(userEmail);
			System.out.println("打印头像路径" + user.getUserImage());
			if (user != null) {
				System.out.println("判断user是否为空");
				if (userPassword.equals(user.getUserPassword())) {
					System.out.println("进入密码密码是否一致");
					// 将用户实体信息存入session
					session.setAttribute("user", user);
					// session.setAttribute("userEmail", user.getUserEmail());
					// 用户输入密码和数据库中的查询一致时，跳转到index页面

					resp.sendRedirect("QueryAllGoodsByPage?goodsType=all");
				} else {
					// 用户输入的密码和数据库中的查询不一致时，跳转首页或者其他页面，暂定为登录界面
					req.setAttribute("loginError", 3);
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 用户通过get方法提交，将用户Id追加在地址栏中
		int userId = Integer.parseInt(req.getParameter("userId"));
		User user = new User();
		UserManagerService usermanagerService = new UserManagerService();
		try {
			user = usermanagerService.selectOneUserById(userId);
			if (user != null) {
				req.setAttribute("user", user);
				req.getRequestDispatcher("lookPersonageInfo.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("noGoods.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
