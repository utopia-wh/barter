package com.barter.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.barter.pojo.Collect;
import com.barter.service.CollectManagerService;

@SuppressWarnings("serial")
@WebServlet("/SelectAllCollectController")
/*
 * 查询所有收物品藏的控制层
 */

public class SelectAllCollectController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		int userId = Integer.parseInt(req.getParameter("userId"));
		System.out.println(userId);
		CollectManagerService collectManagerService = new CollectManagerService();
		ArrayList<Collect> collecttList = new ArrayList<Collect>();
		try {
			collecttList = collectManagerService.selectAllCollect(userId);
			System.out.println(collecttList);
			
				req.setAttribute("collecttList", collecttList);
				req.getRequestDispatcher("myCollectGoods.jsp").forward(req, resp);
				
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}