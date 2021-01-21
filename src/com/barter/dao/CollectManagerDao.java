package com.barter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.barter.dbhelper.DBHelper;
import com.barter.pojo.Collect;

public class CollectManagerDao {
	
	DBHelper db = new DBHelper();

	//增加一个收藏
	public int addCollect(int userId, int goodsId, String goodsName, String goodsType,  String collectTime) {
		String sql = "insert into collect (userId, goodsId, goodsName, goodsType, collectTime) values (?,?,?,?,?)";
		int i = db.executeUpdate(sql, userId, goodsId, goodsName, goodsType,collectTime);
		return i;
	}

	//根据收藏Id查询收藏信息
	public Collect selectOneCollectById(int collectId) throws SQLException {
		Collect collect = new Collect();
		String sql = "select * from collect where collectId=?";
		ResultSet rs = null;
		rs = db.executeQuery(sql, collectId);
		rs.next();
		collect.setCollectId(rs.getInt("collectId"));
		collect.setUserId(rs.getInt("userId"));
		collect.setGoodsId(rs.getInt("goodsId"));
		collect.setGoodsName(rs.getString("goodsName"));
		collect.setGoodsType(rs.getString("goodsType"));
		collect.setCollectTime(rs.getString("collectTime"));
	    return collect;	
	}

	//查询所有的收藏
	public ArrayList<Collect> selectAllCollect(int userId) throws SQLException {
		ArrayList<Collect> collectList = new ArrayList<Collect>();
		Collect collect = null;
		String sql = "select * from collect where userId=? order by collectId desc";
		ResultSet rs = null;
		rs = db.executeQuery(sql, userId);
		while(rs.next()) {
			collect = new Collect();
			collect.setCollectId(rs.getInt("collectId"));
			collect.setUserId(rs.getInt("userId"));
			collect.setGoodsId(rs.getInt("goodsId"));
			collect.setGoodsName(rs.getString("goodsName"));
			collect.setGoodsType(rs.getString("goodsType"));
			collect.setCollectTime(rs.getString("collectTime"));
			collectList.add(collect);
		}
		return collectList;
	}

	//根据收藏Id删除收藏
	public int deleteOneCollectById(int collectId) {
		String sql = "delete from collect where collectId=?";
		int i = db.executeUpdate(sql, collectId);
		return i;
	}
	
   // 判断用户是否已收藏过该物品
	public int selectOneCollected(int userId, int goodsId) throws SQLException {
		int count = 0;
		String sql = "select count(1) from collect where userId=? and goodsId=?";
		ResultSet rs = null;
		rs = db.executeQuery(sql, userId, goodsId);
		if (rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

}
