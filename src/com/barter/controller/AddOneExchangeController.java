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

import com.barter.pojo.Goods;
import com.barter.service.ExchangeManagerService;
import com.barter.service.GoodsManagerService;
/*
 * 发送一个换物申请的控制层
 */

@SuppressWarnings("serial")
@WebServlet("/AddOneExchangeController")
public class AddOneExchangeController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		// 自己的邮箱
		String exchangeSenderEmail = req.getParameter("exchangeSenderEmail");
		if (exchangeSenderEmail.equals("")) {
			req.setAttribute("status", 3);
			req.getRequestDispatcher("exchangeApply.jsp").forward(req, resp);
		}
		// 想换物品的物主邮箱
		String exchangeReceiverEmail = req.getParameter("exchangeReceiverEmail");

		// 判断换物的用户是两个不同的用户
		if (exchangeSenderEmail.equals(exchangeReceiverEmail)) {
			System.out.println("进入判断换物的用户是否是两个不同的用户");
			req.setAttribute("status", 1);
			req.getRequestDispatcher("exchangeApply.jsp").forward(req, resp);
		}
		// 我的物品编号
		int exchangeSenderGoodId = Integer.parseInt(req.getParameter("exchangeSenderGoodId"));
		System.out.println(exchangeSenderGoodId + "我的物品编号");
		try {

			
			Goods goods = null;
			GoodsManagerService goodsManagerService = new GoodsManagerService();

			goods = goodsManagerService.selectOneGoodsById(exchangeSenderGoodId);
			//先判断物品是否存在
			if(goods==null) {
				req.setAttribute("status", 5);
				req.getRequestDispatcher("exchangeApply.jsp").forward(req, resp);
			}
			//若物品存在，判断发起换物者用于换物的物品是否是换物者自己的物品
			if (goods.getUserEmail().equals("exchangeSenderEmail")) {
				req.setAttribute("status", 2);
				req.getRequestDispatcher("exchangeApply.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 获取交换理由
		String exchangeReason = req.getParameter("exchangeReason");
		// 对方的物品编号
		int exchangeReceiverGoodsId = Integer.parseInt(req.getParameter("exchangeReceiverGoodsId"));
		// 获取当前时间为请求换物时间
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
		String exchangeTime = simpleDateFormat.format(new Date());

		System.out.println(exchangeReceiverEmail + "换物接收方");
		System.out.println(exchangeSenderEmail + "换物发起方");
		System.out.println(exchangeReason + "理由");
		System.out.println(exchangeReceiverGoodsId);
		System.out.println(exchangeSenderGoodId);
		System.out.println(exchangeTime);

		ExchangeManagerService exchangeManagerService = new ExchangeManagerService();
		int i = exchangeManagerService.addExchange(exchangeSenderEmail, exchangeReceiverEmail, exchangeSenderGoodId,
				exchangeReceiverGoodsId, exchangeReason, exchangeTime);
		System.out.println(i + "请求成功");
		if (i > 0) {
			System.out.println("发送成功");
			req.setAttribute("exchangeStatus", 1);
			req.getRequestDispatcher("QueryAllGoodsByPage?goodsType=all").forward(req, resp);
		} else {
			req.setAttribute("exchangeStatus", 2);
			req.getRequestDispatcher("QueryAllGoodsByPage?goodsType=all").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
