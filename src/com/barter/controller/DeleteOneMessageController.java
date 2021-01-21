package com.barter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.barter.service.MessageManagerService;

@SuppressWarnings("serial")
@WebServlet("/DeleteOneMessageController")
/*
 * 删除一个消息的控制层
 */
public class DeleteOneMessageController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		//获取消息Id
		int messageId = Integer.parseInt(req.getParameter("messageId"));
		MessageManagerService messageManagerService = new MessageManagerService();
		//若放回的i值大于为1，证明删除消息成功
		messageManagerService.deleteOneMessagesById(messageId);
		//备注: 进行删除后重新查询所有消息
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	

}
