package com.barter.test;

import java.sql.SQLException;

import com.barter.dao.ExchangeManagerDao;

public class testExchangeDao {
	public static void main(String[] args) throws SQLException {
		ExchangeManagerDao dao = new ExchangeManagerDao();
		System.out.println(dao.selectAllReceiveExchange("1522034695@qq.com").size());
	}

}
