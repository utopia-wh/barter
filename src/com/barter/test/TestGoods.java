package com.barter.test;

import java.sql.SQLException;

import com.barter.dao.GoodsManagerDao;

public class TestGoods {
	public static void main(String[] args) throws SQLException {
		GoodsManagerDao md = new GoodsManagerDao();
		//System.out.println(md.selectOneGoodsByGoodsName("手机").get(0).getGoodsName());
	}

}
