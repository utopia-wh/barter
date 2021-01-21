package com.barter.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.barter.pojo.User;
import com.barter.service.CollectManagerService;

@SuppressWarnings("serial")
@WebServlet("/AddCollectController")
/*
 * 增加一个收藏物品的控制层
 */

public class AddCollectController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		//new一个收藏管理的service
		CollectManagerService collectManagerService = new CollectManagerService();
		// 获取物主邮箱
		String goodsUserEmail = req.getParameter("userEmail");
		// 获取当前登录系统的用户邮箱
		User user = (User) req.getSession().getAttribute("user");
		String userEmail = user.getUserEmail();
		if(goodsUserEmail.equals(userEmail)) {
			req.setAttribute("collectStatus", 3);
			req.getRequestDispatcher("QueryAllGoodsByPage?goodsType=all").forward(req, resp);
			return;
		}
		// 获取收藏该物品的用户Id
		int userId = Integer.parseInt(req.getParameter("userId"));
		// 获取收藏的物品Id
		int goodsId = Integer.parseInt(req.getParameter("goodsId"));
		// 获取收藏的物品名称
		String goodsName = req.getParameter("goodsName");
		//判断是否收藏过该物品
		try {
			int record = collectManagerService.selectOneCollected(userId, goodsId);
			if(record>0) {
				req.setAttribute("collectStatus", 4);
				req.getRequestDispatcher("QueryAllGoodsByPage?goodsType=all").forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 货物收藏的物品类型
		String goodsType = req.getParameter("goodsType");
		// 获取当前时间为物品收藏时间
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
		String collectTime = simpleDateFormat.format(new Date());

		System.out.println("...................");
		System.out.println(userId);
		System.out.println(goodsId);
		System.out.println(goodsName);
		System.out.println(collectTime);
		System.out.println(goodsType);
		System.out.println("...................");

		
		int i = collectManagerService.addCollect(userId, goodsId, goodsName, goodsType, collectTime);
		if (i > 0) {
			req.setAttribute("collectStatus", 1);
			req.getRequestDispatcher("QueryAllGoodsByPage?goodsType=all").forward(req, resp);
		} else {
			req.setAttribute("collectStatus", 2);
			req.getRequestDispatcher("QueryAllGoodsByPage?goodsType=all").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}