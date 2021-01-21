package com.barter.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.barter.dao.MessageManagerDao;
import com.barter.pojo.Message;

public class MessageManagerService {

	//增加一个消息
	public int addAnnouncement(String messageSenderEmail, String messageReceiverEmail, String messageContent, String messageTime) {
		MessageManagerDao messageManagerDao = new MessageManagerDao();
		int i = messageManagerDao.addAnnouncement(messageSenderEmail, messageReceiverEmail, messageContent, messageTime);
		return i;
	}

	//根据消息Id删除一个消息
	public int deleteOneMessagesById(int messageId) {
		MessageManagerDao messageManagerDao = new MessageManagerDao();
		//若放回的i值大于为1，证明删除消息成功
		int i = messageManagerDao.deleteOneMessagesById(messageId);
		return i;
	}

	public ArrayList<Message> selectAllMessageByMessageId() {
		// TODO Auto-generated method stub
		return null;
	}

	//查询所有我发出的消息
	public ArrayList<Message> selectAllSendMessage(String userEmail) throws SQLException {
		MessageManagerDao messageManagerDao = new MessageManagerDao();
		ArrayList<Message> messageList = null;
		messageList = messageManagerDao.selectAllSendMessage(userEmail);
		return messageList;
	}
	
	
	//查询所有我收到的消息
	public ArrayList<Message> selectAllReceiveMessage(String userEmail) throws SQLException {
		MessageManagerDao messageManagerDao = new MessageManagerDao();
		ArrayList<Message> messageList = null;
		messageList = messageManagerDao.selectAllReceiveMessage(userEmail);
		return messageList;
	}
}
