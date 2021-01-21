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

/*
 * 分页查询物品控制层
 */

@SuppressWarnings("serial")
@WebServlet("/QueryAllGoodsByPage")
public class QueryAllGoodsByPage extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		String goodsType = req.getParameter("goodsType");
		System.out.println(goodsType+"1233");
		// new物品管理service对象和分页对象
		GoodsManagerService goodsManagerService = new GoodsManagerService();
		GoodsPageManager goodsPageManager = new GoodsPageManager();
		
		goodsPageManager.setGoodsType(goodsType);

		int totalRecord = 0;
		try {
			if (goodsType.equals("all")) {
				// 获取总记录数
				totalRecord = goodsManagerService.getTotalRecord();
				goodsPageManager.setTotalRecord(totalRecord);
			} else {
				totalRecord = goodsManagerService.getTotalRecordByGoodsType(goodsType);
				goodsPageManager.setTotalRecord(totalRecord);
			}
			int currentPage;
			String currentPageTemp = req.getParameter("currentPage");
			if (currentPageTemp == null) {
				currentPage = 1;
			} else {
				currentPage = Integer.parseInt(currentPageTemp);
			}
			System.out.println(currentPage + "当前页");
			goodsPageManager.setCurrentPage(currentPage);
			int pageSize = 6;
			goodsPageManager.setPageSize(pageSize);
			ArrayList<Goods> goodsList = null;
			if (goodsType.equals("all")) {
				goodsList = goodsManagerService.selectAllGoodsByPage(currentPage, pageSize);
			} else {
				goodsList = goodsManagerService.selectOneGoodsByGoodsType(goodsType, currentPage, pageSize);
			}
			goodsPageManager.setGoodsList(goodsList);
			if (goodsList.size() > 0) {
				req.setAttribute("goodsPageManager", goodsPageManager);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			} else {
				resp.sendRedirect("noGoods.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
