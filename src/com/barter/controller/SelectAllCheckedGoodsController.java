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
@WebServlet("/SelectAllCheckedGoodsController")
/*
 * 查询所有审核通过物品控制层
 */
public class SelectAllCheckedGoodsController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		int goodsStatus = Integer.parseInt(req.getParameter("goodsStatus"));
		GoodsManagerService goodsManagerService = new GoodsManagerService();
		ArrayList<Goods> goodsList;
		try {
			goodsList = goodsManagerService.selectAllGoodsByGoodsStatus(goodsStatus);

			if (goodsStatus == 0) {
				req.setAttribute("goodsList", goodsList);
				req.getRequestDispatcher("lookAllChecking.jsp").forward(req, resp);
			} else if (goodsStatus == 1)
				req.setAttribute("goodsList", goodsList);
			req.getRequestDispatcher("lookAllChecked.jsp").forward(req, resp);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
