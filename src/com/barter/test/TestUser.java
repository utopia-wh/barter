package com.barter.test;

import java.sql.SQLException;

import com.barter.dao.UserManagerDao;
import com.barter.pojo.User;

public class TestUser {
	public static void main(String[] args) throws SQLException {
		UserManagerDao dao = new UserManagerDao();
		User user = new User();
		user = dao.selectOneUserByEmail("1522034695@qq.com");
		
		System.out.println(user);
		}
		
	

}
