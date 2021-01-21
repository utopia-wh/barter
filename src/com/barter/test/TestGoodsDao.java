package com.barter.test;

import java.sql.SQLException;

import com.barter.dao.GoodsManagerDao;

public class TestGoodsDao {

	public static void main(String[] args) throws SQLException {
		GoodsManagerDao gd = new GoodsManagerDao();
		System.out.println(gd.getTotalRecordByGoodsType("电子产品"));
		
	}

}
