package com.barter.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.barter.pojo.User;
import com.barter.service.UserManagerService;

@SuppressWarnings("serial")
@WebServlet("/UserRegisterController")
@MultipartConfig
/*
 * 用户注册控制层
 */
public class UserRegisterController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		// 获取用户邮箱
		String userEmail = req.getParameter("userEmail");
		//检测用户邮箱是否已经注册过
		try {
			User user = new User();
			UserManagerService usermanagerService = new UserManagerService();
			user = usermanagerService.selectOneUserByEmail(userEmail);
			if(user!=null) {
				req.setAttribute("registerStatus", 1);
				req.getRequestDispatcher("register.jsp").forward(req, resp);
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取用户密码
		String userPassword = req.getParameter("userPassword");
		// 获取用户名
		String userName = req.getParameter("userName");
		//获取用户电话
		String userTelephone = req.getParameter("userTelephone");
		// 获取用户地址
		String userAddress = req.getParameter("userAddress");
		//获取用户性别
		String userSex = req.getParameter("userSex");
		
		// 获取上传的头像图片
		Part userImageTemp = req.getPart("userImage");
		// 获取上传文件的文件名称
		String fileName = userImageTemp.getSubmittedFileName();
		System.out.println(fileName);
		// 准备给图片重命名，但是不能改变图片的后缀
		// 先获取上传文件的后缀名
		String postfixName = fileName.substring(fileName.indexOf("."));
		System.out.println(postfixName);
		// 获取当前时间给图片起个新名
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		// 重组名字,存入数据的文件名
		String userImage = simpleDateFormat.format(new Date()) + postfixName;
		System.out.println(userImage);
		// 开始保存图片
		// 将图片保存在项目中对应的文件夹内
		String savePath = "E:\\GraduationProject\\workspace\\barter\\WebContent\\userImages";
		// 将文件写入
		userImageTemp.write(savePath + "\\" + userImage);
		//获取当前时间为用户的注册时间
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy年MM月dd日");
		// 重组名字,存入数据的文件名
		String userRegistrationTime = simpleDateFormat1.format(new Date());
		
		System.out.println("...................");
		System.out.println(userEmail);
		System.out.println(userPassword);
		System.out.println(userName);
		System.out.println(userAddress);
		System.out.println(userSex);
		System.out.println(savePath + "\\" + userImage);
		System.out.println(userRegistrationTime);
		System.out.println("...................");
		UserManagerService userManagerService = new UserManagerService();
		int i = userManagerService.addUser(userEmail, userPassword, userName,userTelephone, userAddress, userSex, userImage, userRegistrationTime);
		if(i>0) {
			req.setAttribute("registerStatus", 2);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("registerStatus", 3);
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
