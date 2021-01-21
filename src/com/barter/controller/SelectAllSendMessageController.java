package com.barter.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.barter.pojo.Message;
import com.barter.service.MessageManagerService;

@SuppressWarnings("serial")
@WebServlet("/SelectAllSendMessageController")
/*
 * 查询所有我发出的消息控制层
 */
public class SelectAllSendMessageController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		String userEmail = req.getParameter("userEmail");
		System.out.println(userEmail);
		MessageManagerService messageManagerService = new MessageManagerService();
		ArrayList<Message> messageList = null;
		try {
			messageList = messageManagerService.selectAllSendMessage(userEmail);
//			if(messageList.size()>0) {
				req.setAttribute("messageList", messageList);
				req.getRequestDispatcher("mySendMessage.jsp").forward(req, resp);
//			}
//			else {
//				resp.sendRedirect("noGoods.jsp");
//			}
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
