package com.barter.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.barter.dao.ExchangeManagerDao;
import com.barter.pojo.Exchange;

public class ExchangeManagerService {
	
	ExchangeManagerDao exchangeManagerDao = new ExchangeManagerDao();
	
	//增加一个请求
	public int addExchange(String exchangeSenderEmail, String exchangeReceiverEmail, int exchangeSenderGoodId,
			int exchangeReceiverGoodsId, String exchangeReason, String exchangeTime) {
		int i = exchangeManagerDao.addExchange(exchangeSenderEmail, exchangeReceiverEmail, exchangeSenderGoodId, exchangeReceiverGoodsId, exchangeReason, exchangeTime);
		return i;
	}

	//查询我发出的换物请求
	public ArrayList<Exchange> selectAllSendExchange(String userEmail) throws SQLException {
		ArrayList<Exchange> exchangesList = new ArrayList<Exchange>();
		exchangesList = exchangeManagerDao.selectAllSendExchange(userEmail);
		return exchangesList;
	}

	//查询我收到的换物请求
	public ArrayList<Exchange> selectAllReceiveExchange(String userEmail) throws SQLException {
		ArrayList<Exchange> exchangesList = new ArrayList<Exchange>();
		exchangesList = exchangeManagerDao.selectAllReceiveExchange(userEmail);
		return exchangesList;
	}

	//更改请求状态
	public int updateExchangeStatus(int exchangeId, String exchangeStatus) {
		int i = exchangeManagerDao.updateExchangeStatus(exchangeId, exchangeStatus);
		return i;
	}

}
