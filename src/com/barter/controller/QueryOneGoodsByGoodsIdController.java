package com.barter.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.pojo.Goods;
import com.barter.service.GoodsManagerService;

@SuppressWarnings("serial")
@WebServlet("/QueryOneGoodsByGoodsIdController")
/*
 * 查看某个物品的详情
 */

public class QueryOneGoodsByGoodsIdController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		// 获取物品Id
		Goods goods = new Goods();
		int goodsId = Integer.parseInt(req.getParameter("goodsId"));
		GoodsManagerService goodsManagerService = new GoodsManagerService();
		try {
			goods = goodsManagerService.selectOneGoodsById(goodsId);
			if (goods != null) {
				System.out.println(goods.getUserEmail()+"测试");
				req.setAttribute("goods", goods);
				System.out.println("封装了");
				req.getRequestDispatcher("goodsInfo.jsp").forward(req, resp);
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