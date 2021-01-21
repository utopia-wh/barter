package com.barter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.barter.pojo.User;
import com.barter.service.GoodsManagerService;

/*
 * 根据物品Id更新物品信息信息
 * 用户点击修改物品信息按钮，采用get方法提交，在SelectOneGoodsController控制层里调用doGet方法，先根据物品id查询，进行信息回显再修改
 */
@SuppressWarnings("serial")
@WebServlet("/UpdateOneGoodsController")
public class UpdateOneGoodsController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//防止乱码
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		//获取物品Id
		int goodsId = Integer.parseInt(req.getParameter("goodsId"));
		//获取修改后的物品名称
		String goodsName = req.getParameter("goodsName");
		//获取修改后的物品描述
		String goodsDescription = req.getParameter("goodsDescription");
		GoodsManagerService goodsManagerService = new GoodsManagerService();
		//若放回的i值大于为1，证明更新物品信息成功
		goodsManagerService.updateOneGoodsById(goodsId, goodsName, goodsDescription);
		//备注: 进行更新后重新查询我的上传
		//获取session的值
		System.out.println("获取session中的值");
		User user = (User) req.getSession().getAttribute("user");
		System.out.println(user.getUserEmail());
		resp.sendRedirect("SelectAllGoodsByUserEmailController?userEmail="+user.getUserEmail());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	

}
