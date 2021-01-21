package com.barter.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.barter.pojo.Exchange;
import com.barter.service.ExchangeManagerService;

@SuppressWarnings("serial")
@WebServlet("/SelectAllSendExchangeController")
/*
 * 查询所有我发出的换物申请控制层
 */
public class SelectAllSendExchangeController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		String userEmail = req.getParameter("userEmail");
		System.out.println(userEmail);
		ExchangeManagerService exchangeManagerService = new ExchangeManagerService();
		ArrayList<Exchange> exchangeList = null;
		try {
			exchangeList = exchangeManagerService.selectAllSendExchange(userEmail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			req.setAttribute("exchangeList", exchangeList);
			req.getRequestDispatcher("mySendExchange.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
