package com.barter.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.barter.dao.UserManagerDao;
import com.barter.pojo.User;

/*
 * 用户管理service层
 * 包括增删查改四个功能
 */
public class UserManagerService {
	// 新增一个
	public int addUser(String userEmail, String userPassword, String userName, String userTelephone, String userAddress, String userSex, String  userImage,
			String userRegistrationTime) {
		UserManagerDao userManagerDao = new UserManagerDao();
		int i = userManagerDao.addUser(userEmail, userPassword, userName, userTelephone, userAddress, userSex, userImage, userRegistrationTime);
		return i;
	}
	
	//根据用户邮箱查询一个用户
	public User selectOneUserByEmail(String userEmail) throws SQLException {	
		User user = new User();
		UserManagerDao userManagerDao = new UserManagerDao();
		user = userManagerDao.selectOneUserByEmail(userEmail);
		return user;
		
	}

	//查询所有用户
	public ArrayList<User> selectAllUser() throws SQLException {
		UserManagerDao userManagerDao = new UserManagerDao();
		ArrayList<User> userList = userManagerDao.selectAllUser();
		return userList;
	}

	//根据用户Id删除一个用户
	public int deleteOneUserById(int userId) {
		UserManagerDao userManagerDao = new UserManagerDao();
		int i = userManagerDao.deleteOneUserById(userId);
		return i;
	}
	
	//根据用户Id更新个人信息
	public int UpdateOneUserById(int userId, String userName, String userTelephone, String userAddress) {
		UserManagerDao userManagerDao = new UserManagerDao();
		int i = userManagerDao.UpdateOneUserById(userId, userName, userTelephone, userAddress);
		return i;
	}

	//根据用户Id查询一个用户
	public User selectOneUserById(int userId) throws SQLException {
		User user = new User();
		UserManagerDao userManagerDao = new UserManagerDao();
		user = userManagerDao.selectOneUserById(userId);
		return user;
	}

	
	//根据用户手机号码进行密码修改
	public int UpdateUserPasswordByTelephone(String userPassword, String userTelephone) {
		UserManagerDao userManagerDao = new UserManagerDao();
		int i = userManagerDao.UpdateUserPasswordByTelephone(userPassword, userTelephone);
		return i;
	}
}
