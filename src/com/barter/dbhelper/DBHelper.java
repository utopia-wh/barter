package com.barter.dbhelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {
	/**
	 * 初始化通用层，操作数据库必备的东西
	 */
	String url="jdbc:mysql://localhost:3306/barter?characterEncoding=utf8&useSSL=false";
	String sqlName="root";
	String sqlPsd = "root";
	Connection conn = null;
	PreparedStatement pstat = null;
	ResultSet rs = null;
	
	
	/**
	 * 连接的方法
	 */
	public void getConnection() {
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			conn = DriverManager.getConnection(url, sqlName, sqlPsd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 用来执行增删改操作的方法
	 * 传入一个可变参数Object ...objects
	 * 可变参数就是不管传入多少个参数都没事
	 */
	public int executeUpdate(String sql,Object ...objects) {
		//获取连接对象
		getConnection();
		//创建语句发送器
		int i = 0;
		try {
			pstat = conn.prepareStatement(sql);
			//再创建一个方法专门为上边的sql语句进行赋值
			setParamer(objects);
			i = pstat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 为占位符赋值
	 * @param objects
	 */
	public void setParamer(Object ...objects) {
		try {
				for (int i = 0; i < objects.length; i++) {
					pstat.setObject(i+1,objects[i]);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 执行查询的方法
	 * @return
	 */
	public ResultSet executeQuery(String sql,Object ...objects) {
		try {
			getConnection();
			pstat = conn.prepareStatement(sql);
			setParamer(objects);
			rs = pstat.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	/**
	 * 关闭连接
	 * @throws SQLException 
	 */
	public void colse() throws SQLException {

		if(rs!=null) {
			rs.close();
		}
		if(pstat!=null) {
			pstat.close();
		}
		if(conn!=null) {
			conn.close();
		}
	}
}
