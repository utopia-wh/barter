package com.barter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.barter.dbhelper.DBHelper;
import com.barter.pojo.User;

/*
 * 用户管理Dao层
 * 包括增删查改四个功能
 */
public class UserManagerDao {

	DBHelper db = new DBHelper();

	// 新增一个用户
	public int addUser(String userEmail, String userPassword, String userName, String userTelephone, String userAddress,
			String userSex, String userImage, String userRegistrationTime) {
		String sql = "insert into user(userEmail, userPassword, userName, userTelephone, userAddress, userSex,  userImage, userRegistrationTime) values (?,?,?,?,?,?,?,?)";
		int i = db.executeUpdate(sql, userEmail, userPassword, userName, userTelephone, userAddress, userSex, userImage,
				userRegistrationTime);
		return i;

	}

	// 根据用户邮箱查询一个用户
	public User selectOneUserByEmail(String userEmail) throws SQLException {
		String sql = "select * from user where userEmail=?";
		ResultSet rs = null;
		User user = new User();
		rs = db.executeQuery(sql, userEmail);
		// 将结果指向第一条并判断是否为空，为空的，返回的user为null
		if (!rs.next()) {
			user = null;
		}
		else {
			user.setUserId(rs.getInt("userId"));
			user.setUserEmail(rs.getString("userEmail"));
			user.setUserPassword(rs.getString("userPassword"));
			user.setUserName(rs.getString("userName"));
			user.setUserTelephone(rs.getString("userTelephone"));
			user.setUserAddress(rs.getString("userAddress"));
			user.setUserSex(rs.getString("userSex"));
			user.setUserImage(rs.getString("userImage"));
			user.setUserRegistrationTime(rs.getString("userRegistrationTime"));
			user.setPermissionLevel(rs.getInt("permissionLevel"));
			user.setUserStatus(rs.getInt("userStatus"));

		}
		return user;
	}

	// 根据用户Id查询一个用户
	public User selectOneUserById(int userId) throws SQLException {
		String sql = "select * from user where userId=?";
		ResultSet rs = null;
		User user = new User();
		rs = db.executeQuery(sql, userId);
		// 将结果指向第一条
		rs.next();
		user.setUserId(rs.getInt("userId"));
		user.setUserEmail(rs.getString("userEmail"));
		user.setUserPassword(rs.getString("userPassword"));
		user.setUserName(rs.getString("userName"));
		user.setUserTelephone(rs.getString("userTelephone"));
		user.setUserAddress(rs.getString("userAddress"));
		user.setUserSex(rs.getString("userSex"));
		user.setUserImage(rs.getString("userImage"));
		user.setUserRegistrationTime(rs.getString("userRegistrationTime"));
		user.setPermissionLevel(rs.getInt("permissionLevel"));
		user.setUserStatus(rs.getInt("userStatus"));

		return user;
	}

	// 查询所有用户
	public ArrayList<User> selectAllUser() throws SQLException {
		String sql = "select * from user where permissionLevel=1 order by userId desc";
		ResultSet rs = null;
		User user = null;
		ArrayList<User> userList = new ArrayList<User>();
		rs = db.executeQuery(sql);
		while (rs.next()) {
			user = new User();
			user.setUserId(rs.getInt("userId"));
			user.setUserEmail(rs.getString("userEmail"));
			user.setUserPassword(rs.getString("userPassword"));
			user.setUserName(rs.getString("userName"));
			user.setUserTelephone(rs.getString("userTelephone"));
			user.setUserAddress(rs.getString("userAddress"));
			user.setUserSex(rs.getString("userSex"));
			user.setUserImage(rs.getString("userImage"));
			user.setUserRegistrationTime(rs.getString("userRegistrationTime"));
			user.setPermissionLevel(rs.getInt("permissionLevel"));
			user.setUserStatus(rs.getInt("userStatus"));
			userList.add(user);
		}

		return userList;
	}

	// 根据用户Id删除用户
	public int deleteOneUserById(int userId) {
		String sql = "delete from User where userId=?";
		int i = db.executeUpdate(sql, userId);
		return i;
	}

	// 根据用户Id更新用户个人信息
	public int UpdateOneUserById(int userId, String userName, String userTelephone, String userAddress) {
		String sql = "update user set userName = ?, userTelephone = ?, userAddress = ? where userId = ? ";
		int i = db.executeUpdate(sql, userName, userTelephone, userAddress, userId);
		return i;
	}

	// 根据用户手机号码进行密码修改
	public int UpdateUserPasswordByTelephone(String userPassword, String userTelephone) {
		String sql = "update user set userPassword = ? where userTelephone = ?";
		int i = db.executeUpdate(sql, userPassword, userTelephone);
		return i;
	}
}
