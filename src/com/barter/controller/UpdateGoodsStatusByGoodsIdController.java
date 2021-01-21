package com.barter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.barter.service.GoodsManagerService;

/*
 * 根据物品Id更新物品的状态为1，表示审核通过
 */
@SuppressWarnings("serial")
@WebServlet("/UpdateGoodsStatusByGoodsIdController")
public class UpdateGoodsStatusByGoodsIdController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//防止乱码
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		//获取物品Id
		int goodsId = Integer.parseInt(req.getParameter("goodsId"));
		System.out.println(goodsId+"/////////");
		GoodsManagerService goodsManagerService = new GoodsManagerService();
		int i = goodsManagerService.updateGoodsStatusByGoodsId(goodsId);
		if(i>0) {
			resp.sendRedirect("SelectAllCheckedGoodsController?goodsStatus=0");
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
