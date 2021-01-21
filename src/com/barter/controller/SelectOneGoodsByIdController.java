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
@WebServlet("/SelectOneGoodsByIdController")
/*
 * 修改物品信息时数据回显
 */

public class SelectOneGoodsByIdController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		//获取物品Id
		Goods goods = new Goods();
		int goodsId = Integer.parseInt(req.getParameter("goodsId"));
		GoodsManagerService goodsManagerService = new GoodsManagerService();
		try {
			  goods = goodsManagerService.selectOneGoodsById(goodsId);
			  if(goods!=null) {
					req.setAttribute("goods", goods);
					req.getRequestDispatcher("updateGoodsInfo.jsp").forward(req, resp);
				}
				else {
					resp.sendRedirect("noGoods.jsp");
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