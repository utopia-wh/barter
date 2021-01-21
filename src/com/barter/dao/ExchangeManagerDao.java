package com.barter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.barter.dbhelper.DBHelper;
import com.barter.pojo.Exchange;


public class ExchangeManagerDao {
	
	DBHelper db = new DBHelper();

	//增加一个请求
	public int addExchange(String exchangeSenderEmail, String exchangeReceiverEmail, int exchangeSenderGoodId,
			int exchangeReceiverGoodsId, String exchangeReason, String exchangeTime) {
		String sql = "insert into exchange (exchangeSenderEmail, exchangeReceiverEmail, exchangeSenderGoodId, exchangeReceiverGoodsId, exchangeReason, exchangeTime) values (?,?,?,?,?,?)";
		int i = db.executeUpdate(sql, exchangeSenderEmail, exchangeReceiverEmail, exchangeSenderGoodId, exchangeReceiverGoodsId, exchangeReason, exchangeTime);
		return i;
	}

	//查询我发出的换物申请
	public ArrayList<Exchange> selectAllSendExchange(String userEmail) throws SQLException {
		ArrayList<Exchange> exchangeList = new ArrayList<Exchange>();
		Exchange exchange = null;
		ResultSet rs = null;
		String sql = "select * from exchange where exchangeSenderEmail=? order by exchangeId desc";
		rs = db.executeQuery(sql, userEmail);
		while(rs.next()) {
			exchange = new Exchange();
			exchange.setExchangeId(rs.getInt("exchangeId"));
			exchange.setExchangeSenderEmail(rs.getString("exchangeSenderEmail"));
			exchange.setExchangeReceiverEmail(rs.getString("exchangeReceiverEmail"));
			exchange.setExchangeSenderGoodId(rs.getInt("exchangeSenderGoodId"));
			exchange.setExchangeReceiverGoodsId(rs.getInt("exchangeReceiverGoodsId"));
			exchange.setExchangeReason(rs.getString("exchangeReason"));
			exchange.setExchangeTime(rs.getString("exchangeTime"));
			exchange.setExchangeStatus(rs.getString("exchangeStatus"));
			exchange.setSenderVisible(rs.getInt("senderVisible"));
			exchange.setReceiverVisible(rs.getInt("receiverVisible"));
			exchangeList.add(exchange);
			
		}
		return exchangeList;
		
	}

	//查询我收到的换物申请
	public ArrayList<Exchange> selectAllReceiveExchange(String userEmail) throws SQLException {
		ArrayList<Exchange> exchangeList = new ArrayList<Exchange>();
		Exchange exchange = null;
		ResultSet rs = null;
		String sql = "select * from exchange where exchangeReceiverEmail=? order by exchangeId desc";
		rs = db.executeQuery(sql, userEmail);
		while(rs.next()) {
			exchange = new Exchange();
			exchange.setExchangeId(rs.getInt("exchangeId"));
			exchange.setExchangeSenderEmail(rs.getString("exchangeSenderEmail"));
			exchange.setExchangeReceiverEmail(rs.getString("exchangeReceiverEmail"));
			exchange.setExchangeSenderGoodId(rs.getInt("exchangeSenderGoodId"));
			exchange.setExchangeReceiverGoodsId(rs.getInt("exchangeReceiverGoodsId"));
			exchange.setExchangeReason(rs.getString("exchangeReason"));
			exchange.setExchangeTime(rs.getString("exchangeTime"));
			exchange.setExchangeStatus(rs.getString("exchangeStatus"));
			exchange.setSenderVisible(rs.getInt("senderVisible"));
			exchange.setReceiverVisible(rs.getInt("receiverVisible"));
			exchangeList.add(exchange);
			
		}
		return exchangeList;
	}

	//更改请求状态
	public int updateExchangeStatus(int exchangeId, String exchangeStatus) {
		String sql = "update exchange set exchangeStatus=? where exchangeId = ? ";
		int i = db.executeUpdate(sql,exchangeStatus, exchangeId);
		return i;
	}

}
