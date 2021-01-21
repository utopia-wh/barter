package com.barter.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.pojo.Goods;
import com.barter.service.GoodsManagerService;


@SuppressWarnings("serial")
@WebServlet("/SelectAllGoodsByUserEmailController")

/*
 * 根据邮箱查询物品的控制层
 */
public class SelectAllGoodsByUserEmailController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		String userEmail = req.getParameter("userEmail");
		System.out.println(userEmail);
		
		GoodsManagerService goodsManagerService = new GoodsManagerService();
		try {
			ArrayList<Goods> goodsList = null;
			goodsList = goodsManagerService.selectOneGoodsByUserEmail(userEmail);
			
//			if(goodsList.size()>0) {
				req.setAttribute("goodsList", goodsList);
				req.getRequestDispatcher("myReleaseGoods.jsp").forward(req, resp);
//			}
//			else {
//				resp.sendRedirect("noGoods.jsp");
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}	
}
