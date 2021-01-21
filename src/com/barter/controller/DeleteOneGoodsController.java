package com.barter.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.pojo.User;
import com.barter.service.GoodsManagerService;

@SuppressWarnings("serial")
@WebServlet("/DeleteOneGoodsController")
/*
 * 删除一个物品的控制层
 */
public class DeleteOneGoodsController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		//获取当前进行删除的物品的状态
		int goodsStatus = Integer.parseInt(req.getParameter("goodsStatus"));
		System.out.println(goodsStatus+"状态");
		//获取物品Id
		int goodsId = Integer.parseInt(req.getParameter("goodsId"));
		System.out.println(goodsId+"测试");
		GoodsManagerService goodsManagerService = new GoodsManagerService();
		//若放回的i值大于为1，证明删除物品成功
		int i = goodsManagerService.deleteOneGoodsById(goodsId);
		
		//获取当前登录用户的信息
		System.out.println("获取session中的值");
		User user = (User) req.getSession().getAttribute("user");
		int permissionLevel = user.getPermissionLevel();
		if(permissionLevel==2&&goodsStatus==1) {
			if(i>0) {
				req.setAttribute("deleteStatus", 1);
				req.getRequestDispatcher("SelectAllCheckedGoodsController?goodsStatus=1").forward(req, resp);
			}
			else {
				req.setAttribute("deleteStatus", 2);
				req.getRequestDispatcher("SelectAllCheckedGoodsController?goodsStatus=1").forward(req, resp);
			}
			
		}
		else if(permissionLevel==2&&goodsStatus==0){
			if(i>0) {
				req.setAttribute("deleteStatus", 1);
				req.getRequestDispatcher("SelectAllCheckedGoodsController?goodsStatus=0").forward(req, resp);
			}
			else {
				req.setAttribute("deleteStatus", 2);
				req.getRequestDispatcher("SelectAllCheckedGoodsController?goodsStatus=0").forward(req, resp);
			}
		}
		else {
			if(i>0) {
				req.setAttribute("deleteStatus", 1);
				req.getRequestDispatcher("SelectAllGoodsByUserEmailController?userEmail="+user.getUserEmail()).forward(req, resp);
			}
			else {
				req.setAttribute("deleteStatus", 2);
				req.getRequestDispatcher("SelectAllGoodsByUserEmailController?userEmail="+user.getUserEmail()).forward(req, resp);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
