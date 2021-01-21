package com.barter.test;

import java.sql.SQLException;

import com.barter.dao.MessageManagerDao;

public class testMessageDao {
	public static void main(String[] args) throws SQLException {
		MessageManagerDao mmd = new MessageManagerDao();
		System.out.println(mmd.selectAllSendMessage("201412479@qq.com"));
		//System.out.println(mmd.selectAllSendMessage("201412479@qq.com").get(0).getMessageReceiverEmail());
	}

}
