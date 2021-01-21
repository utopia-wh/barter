package com.barter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.barter.dbhelper.DBHelper;
import com.barter.pojo.Goods;

/*
 * 物品管理Dao层
 * 包括增删查改四个功能
 */
public class GoodsManagerDao {

	DBHelper db = new DBHelper();

	// 发布一个物品
	public int addGoods(String goodsName, String goodsDescription, String goodsImage, String goodsReleaseTime,
			String goodsDegree, String goodsType, String userEmail) {
		String sql = "insert into goods(goodsName, goodsDescription, goodsImage, goodsReleaseTime, goodsDegree, goodsType, userEmail) values (?,?,?,?,?,?,?)";
		int i = db.executeUpdate(sql, goodsName, goodsDescription, goodsImage, goodsReleaseTime, goodsDegree, goodsType,
				userEmail);
		return i;
	}

	// 根据物品Id查询一个物品
	public Goods selectOneGoodsById(int goodsId) throws SQLException {
		String sql = "select * from goods where goodsId=?";
		ResultSet rs = null;
		Goods goods = new Goods();
		rs = db.executeQuery(sql, goodsId);
		if(!rs.next()) {
			goods = null;
		}
		else {
			goods.setGoodsId(rs.getInt("goodsId"));
			goods.setGoodsName(rs.getString("goodsName"));
			goods.setGoodsDescription(rs.getString("goodsDescription"));
			goods.setGoodsImage(rs.getString("goodsImage"));
			goods.setGoodsStatus(rs.getInt("goodsStatus"));
			goods.setGoodsReleaseTime(rs.getString("goodsReleaseTime"));
			goods.setGoodsDegree(rs.getString("goodsDegree"));
			goods.setGoodsType(rs.getString("goodsType"));
			goods.setUserEmail(rs.getString("userEmail"));
		}
		return goods;
	}

	// 根据物品名称模糊查询通过审核的物品
	public ArrayList<Goods> selectOneGoodsByGoodsName(String goodsName, int currentPage, int pageSize)
			throws SQLException {
		String value = "%" + goodsName + "%";
		String sql = "select * from goods where goodsName like ? or goodsDescription like ? and goodsStatus=1 limit ?,?";
		ResultSet rs = null;
		Goods goods = null;
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		rs = db.executeQuery(sql, value, value,(currentPage - 1) * pageSize, pageSize);
		while (rs.next()) {
			goods = new Goods();
			goods.setGoodsId(rs.getInt("goodsId"));
			goods.setGoodsName(rs.getString("goodsName"));
			if (rs.getString("goodsDescription").length() > 70) {
				goods.setGoodsDescription("  " + rs.getString("goodsDescription").substring(0, 70) + "...");
			} else {
				goods.setGoodsDescription(rs.getString("goodsDescription"));
			}
			goods.setGoodsImage(rs.getString("goodsImage"));
			goods.setGoodsStatus(rs.getInt("goodsStatus"));
			goods.setGoodsReleaseTime(rs.getString("goodsReleaseTime"));
			goods.setGoodsDegree(rs.getString("goodsDegree"));
			goods.setGoodsType(rs.getString("goodsType"));
			goods.setUserEmail(rs.getString("userEmail"));
			goodsList.add(goods);
		}
		return goodsList;

	}

	// 查询所有物品
	public ArrayList<Goods> selectAllGoods() throws SQLException {
		String sql = "select * from goods";
		ResultSet rs = null;
		Goods goods = null;
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		rs = db.executeQuery(sql);
		while (rs.next()) {
			goods = new Goods();
			goods.setGoodsId(rs.getInt("goodsId"));
			goods.setGoodsName(rs.getString("goodsName"));
			if (rs.getString("goodsDescription").length() > 70) {
				goods.setGoodsDescription("  " + rs.getString("goodsDescription").substring(0, 70) + "...");
			} else {
				goods.setGoodsDescription(rs.getString("goodsDescription"));
			}
			goods.setGoodsImage(rs.getString("goodsImage"));
			goods.setGoodsStatus(rs.getInt("goodsStatus"));
			goods.setGoodsReleaseTime(rs.getString("goodsReleaseTime"));
			goods.setGoodsDegree(rs.getString("goodsDegree"));
			goods.setGoodsType(rs.getString("goodsType"));
			goods.setUserEmail(rs.getString("userEmail"));
			goodsList.add(goods);
		}
		return goodsList;

	}

	// 查询所有的物品，这是根据物品状态来决定的
	public ArrayList<Goods> selectAllGoodsByGoodsStatus(int goodsStatus) throws SQLException {
		String sql = "select * from goods where goodsStatus=?";
		ResultSet rs = null;
		Goods goods = null;
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		rs = db.executeQuery(sql, goodsStatus);
		while (rs.next()) {
			goods = new Goods();
			goods.setGoodsId(rs.getInt("goodsId"));
			goods.setGoodsName(rs.getString("goodsName"));
			if (rs.getString("goodsDescription").length() > 70) {
				goods.setGoodsDescription("  " + rs.getString("goodsDescription").substring(0, 70) + "...");
			} else {
				goods.setGoodsDescription(rs.getString("goodsDescription"));
			}
			goods.setGoodsImage(rs.getString("goodsImage"));
			goods.setGoodsStatus(rs.getInt("goodsStatus"));
			goods.setGoodsReleaseTime(rs.getString("goodsReleaseTime"));
			goods.setGoodsDegree(rs.getString("goodsDegree"));
			goods.setGoodsType(rs.getString("goodsType"));
			goods.setUserEmail(rs.getString("userEmail"));
			goodsList.add(goods);
		}
		return goodsList;
	}

	// 根据物品类型查询物品加上物品状态为1,用户和管理员使用
	public ArrayList<Goods> selectOneGoodsByGoodsType(String goodsType, int currentPage, int pageSize)
			throws SQLException {
		String sql = "select * from goods where goodsType=? and goodsStatus=1 limit ?,?";
		// db.executeQuery(sql, goodsType);
		ResultSet rs = null;
		Goods goods = null;
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		rs = db.executeQuery(sql, goodsType, (currentPage - 1) * pageSize, pageSize);
		while (rs.next()) {
			goods = new Goods();
			goods.setGoodsId(rs.getInt("goodsId"));
			goods.setGoodsName(rs.getString("goodsName"));
			if (rs.getString("goodsDescription").length() > 70) {
				goods.setGoodsDescription("  " + rs.getString("goodsDescription").substring(0, 70) + "...");
			} else {
				goods.setGoodsDescription(rs.getString("goodsDescription"));
			}
			goods.setGoodsImage(rs.getString("goodsImage"));
			goods.setGoodsStatus(rs.getInt("goodsStatus"));
			goods.setGoodsReleaseTime(rs.getString("goodsReleaseTime"));
			goods.setGoodsDegree(rs.getString("goodsDegree"));
			goods.setGoodsType(rs.getString("goodsType"));
			goods.setUserEmail(rs.getString("userEmail"));
			goodsList.add(goods);
		}
		return goodsList;
	}

	// 根据用户邮箱查询该用户发布的所有物品
	public ArrayList<Goods> selectAllGoodsByUserEmail(String userEmail) throws SQLException {
		String sql = "select * from goods where userEmail=?";
		db.executeQuery(sql, userEmail);
		ResultSet rs = null;
		Goods goods = null;
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		rs = db.executeQuery(sql);
		while (rs.next()) {
			goods = new Goods();
			goods.setGoodsId(rs.getInt("goodsId"));
			goods.setGoodsName(rs.getString("goodsName"));
			if (rs.getString("goodsDescription").length() > 70) {
				goods.setGoodsDescription("  " + rs.getString("goodsDescription").substring(0, 70) + "...");
			} else {
				goods.setGoodsDescription(rs.getString("goodsDescription"));
			}
			goods.setGoodsImage(rs.getString("goodsImage"));
			goods.setGoodsStatus(rs.getInt("goodsStatus"));
			goods.setGoodsReleaseTime(rs.getString("goodsReleaseTime"));
			goods.setGoodsDegree(rs.getString("goodsDegree"));
			goods.setGoodsType(rs.getString("goodsType"));
			goods.setUserEmail(rs.getString("userEmail"));
			goodsList.add(goods);
		}
		return goodsList;

	}

	// 根据物品Id删除一个物品
	public int deleteOneGoodsById(int goodsId) {
		String sql = "delete from goods where goodsId=?";
		int i = db.executeUpdate(sql, goodsId);
		return i;
	}

	// 根据物品Id更新一个物品
	public int updateOneGoodsById(int goodsId, String goodsName, String goodsDescription) {
		String sql = "update goods set goodsName = ?, goodsDescription = ? where goodsId = ? ";
		int i = db.executeUpdate(sql, goodsName, goodsDescription, goodsId);
		return i;
	}

	// 根据物品Id更新物品的状态为1，表示审核通过
	public int updateGoodsStatusByGoodsId(int goodsId) {
		String sql = "update goods set goodsStatus=1 where goodsId = ? ";
		int i = db.executeUpdate(sql, goodsId);
		return i;
	}

	// 统计共有多少个物品（goods表共有多少条记录）
	public int getTotalRecord() throws SQLException {
		int count = 0;
		String sql = "select count(1) from goods where goodsStatus=1";
		ResultSet rs = null;
		rs = db.executeQuery(sql);
		if (rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	// 统计共有多少个物品（goods表共有多少条记录）当物品有类型时
	public int getTotalRecordByGoodsType(String goodsType) throws SQLException {
		int count = 0;
		String sql = "select count(1) as num from goods where goodsStatus=1 and goodsType=?";
		ResultSet rs = null;
		rs = db.executeQuery(sql, goodsType);
		if (rs.next()) {
			count = rs.getInt("num");
		}
		return count;
	}

	// 统计共有多少个物品（goods表共有多少条记录）当通过物品名进行模糊搜索时
	public int getTotalRecordByLIkeGoodsName(String goodsName) throws SQLException {
		int count = 0;
		String value = "%" + goodsName + "%";
		String sql = "select count(1) from goods where goodsName like ? and goodsStatus=1";
		ResultSet rs = null;
		rs = db.executeQuery(sql, value);
		if (rs.next()) {
			count = rs.getInt(1);
		}
		return count;
	}

	// 查询某一页的物品数据集合，这是所有物品的分页处理
	// currentPage表示当前页（页码），pageSize表示每页显示多少数据
	public ArrayList<Goods> selectAllGoodsByPage(int currentPage, int pageSize) throws SQLException {
		String sql = "select * from goods where goodsStatus=1 limit ?,?";
		ResultSet rs = null;
		Goods goods = null;
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		rs = db.executeQuery(sql, (currentPage - 1) * pageSize, pageSize);
		while (rs.next()) {
			goods = new Goods();
			goods.setGoodsId(rs.getInt("goodsId"));
			goods.setGoodsName(rs.getString("goodsName"));
			if (rs.getString("goodsDescription").length() > 70) {
				goods.setGoodsDescription("  " + rs.getString("goodsDescription").substring(0, 70) + "...");
			} else {
				goods.setGoodsDescription(rs.getString("goodsDescription"));
			}
			goods.setGoodsImage(rs.getString("goodsImage"));
			goods.setGoodsStatus(rs.getInt("goodsStatus"));
			goods.setGoodsReleaseTime(rs.getString("goodsReleaseTime"));
			goods.setGoodsDegree(rs.getString("goodsDegree"));
			goods.setGoodsType(rs.getString("goodsType"));
			goods.setUserEmail(rs.getString("userEmail"));
			goodsList.add(goods);
		}
		return goodsList;
	}
}
