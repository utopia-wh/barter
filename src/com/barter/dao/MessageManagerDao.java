package com.barter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.barter.dbhelper.DBHelper;
import com.barter.pojo.Message;

public class MessageManagerDao {
	
	DBHelper db = new DBHelper();

	//增加一个消息
	public int addAnnouncement(String messageSenderEmail, String messageReceiverEmail, String messageContent, String messageTime) {
		String sql = "insert into message(messageSenderEmail, messageReceiverEmail, messageContent, messageTime) values (?,?,?,?)";
		int i = db.executeUpdate(sql,messageSenderEmail, messageReceiverEmail, messageContent, messageTime);
		return i;
	}

	//根据消息Id删除一个消息
	public int deleteOneMessagesById(int messageId) {
		String sql = "delete from message where messageEmail=?";
		int i = db.executeUpdate(sql, messageId);
		return i;
	}

	//查询所有我发出的消息
	public ArrayList<Message> selectAllSendMessage(String userEmail) throws SQLException {
		
		ArrayList<Message> messageList = new ArrayList<Message>();
		Message message = null;
		ResultSet rs = null;
		String sql = "select * from message where messageSenderEmail=? order by messageId desc";
		rs = db.executeQuery(sql, userEmail);
		while(rs.next()) {
			message = new Message();
			message.setMessageId(rs.getInt("messageId"));
			message.setMessageSenderEmail(rs.getString("messageSenderEmail"));
			message.setMessageReceiverEmail(rs.getString("messageReceiverEmail"));
			message.setMessageContent(rs.getString("messageContent"));
			message.setMessageTime(rs.getString("messageTime"));
			messageList.add(message);
		}
		return messageList;
	}
	
	
	//查询所有我收到的消息
		public ArrayList<Message> selectAllReceiveMessage(String userEmail) throws SQLException {
			
			ArrayList<Message> messageList = new ArrayList<Message>();
			Message message = null;
			ResultSet rs = null;
			String sql = "select * from message where messageReceiverEmail=? order by messageId desc";
			rs = db.executeQuery(sql, userEmail);
			while(rs.next()) {
				message = new Message();
				message.setMessageId(rs.getInt("messageId"));
				message.setMessageSenderEmail(rs.getString("messageSenderEmail"));
				message.setMessageReceiverEmail(rs.getString("messageReceiverEmail"));
				message.setMessageContent(rs.getString("messageContent"));
				message.setMessageTime(rs.getString("messageTime"));
				messageList.add(message);
			}
			return messageList;
		}

}
