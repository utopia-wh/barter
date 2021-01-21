package com.barter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.pojo.User;
import com.barter.service.ExchangeManagerService;
/*
 * 用户对收到的换物请求进行处理，修改对应的换物请求状态
 */
@SuppressWarnings("serial")
@WebServlet("/UpdateExchangeStatusController")
public class UpdateExchangeStatusController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//防止乱码
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		//获取请求Id
		int exchangeId = Integer.parseInt(req.getParameter("exchangeId"));
		System.out.println(exchangeId+"请求id");
		//获取请求转态
		String exchangeStatus = req.getParameter("exchangeStatus");
		System.out.println(exchangeStatus+"请求状态");
		
		ExchangeManagerService exchangeManagerService = new ExchangeManagerService();
		exchangeManagerService.updateExchangeStatus(exchangeId, exchangeStatus);
		//获取session的值
		System.out.println("获取session中的值");
		User user = (User) req.getSession().getAttribute("user");
		System.out.println(user.getUserEmail());
		resp.sendRedirect("SelectAllReceiveExchangeController?userEmail="+user.getUserEmail());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
