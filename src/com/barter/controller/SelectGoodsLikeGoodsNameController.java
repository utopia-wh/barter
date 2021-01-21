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
@WebServlet("/SelectGoodsLikeGoodsNameController")

/*
 * 查询物品的控制层 post方法为全局的模糊搜索，模糊字段为物品的名称
 */
public class SelectGoodsLikeGoodsNameController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		String goodsName = req.getParameter("keyWord");
		System.out.println(goodsName);

		GoodsManagerService goodsManagerService = new GoodsManagerService();

		// 测试
		GoodsPageManager goodsPageManager = new GoodsPageManager();
		

		int currentPage;
		String currentPageTemp = req.getParameter("currentPage");
		System.out.println(currentPageTemp+"地址栏的当前页");
		if (currentPageTemp == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPageTemp);
			
		}
		System.out.println(currentPage+"当前页");

		try {
			goodsPageManager.setGoodsName(goodsName);
			// 获取总记录数
			int totalRecord = goodsManagerService.getTotalRecordByLIkeGoodsName(goodsName);
			System.out.println(totalRecord+"总记录数");
			goodsPageManager.setTotalRecord(totalRecord);
			goodsPageManager.setCurrentPage(currentPage);
			int pageSize = 6;
			goodsPageManager.setPageSize(pageSize);
			ArrayList<Goods> goodsList;
			goodsList = goodsManagerService.selectOneGoodsByGoodsName(goodsName, currentPage, pageSize);
			goodsPageManager.setGoodsList(goodsList);
			if (goodsList.size() > 0) {
				req.setAttribute("goodsPageManager", goodsPageManager);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			else {
				resp.sendRedirect("noGoods.jsp");
			}
			// 测试
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try {
//			ArrayList<Goods> goodsList = null;
//			goodsList = goodsManagerService.selectOneGoodsByGoodsName(goodsName);
//			
//			if(goodsList.size()>0) {
//				req.setAttribute("goodsList", goodsList);
//				req.getRequestDispatcher("index.jsp").forward(req, resp);
//			}
//			else {
//				resp.sendRedirect("noGoods.jsp");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
