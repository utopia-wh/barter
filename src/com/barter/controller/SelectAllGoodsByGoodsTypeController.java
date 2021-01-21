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
import com.barter.util.GoodsPageManager;

@SuppressWarnings("serial")
@WebServlet("/SelectAllGoodsByGoodsTypeController")

/*
 * 根据物品类型查询物品的控制层
 */
public class SelectAllGoodsByGoodsTypeController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		GoodsManagerService goodsManagerService = new GoodsManagerService();
		String goodsType = req.getParameter("goodsType");
		// 测试
		GoodsPageManager goodsPageManager = new GoodsPageManager();

		int currentPage;
		String currentPageTemp = req.getParameter("currentPage");
		if (currentPageTemp == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPageTemp);
		}

		try {
			// 获取总记录数
			int totalRecord = goodsManagerService.getTotalRecord();
			goodsPageManager.setTotalRecord(totalRecord);
			goodsPageManager.setCurrentPage(currentPage);
			int pageSize = 6;
			goodsPageManager.setPageSize(pageSize);
			ArrayList<Goods> goodsList;
			goodsList = goodsManagerService.selectOneGoodsByGoodsType(goodsType, currentPage, pageSize);
			goodsPageManager.setGoodsList(goodsList);
			if (goodsList.size() > 0) {
				req.setAttribute("goodsPageManager", goodsPageManager);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			// 测试
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
