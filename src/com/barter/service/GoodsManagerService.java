package com.barter.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.barter.dao.GoodsManagerDao;
import com.barter.pojo.Goods;

/*
 * 物品管理service层
 * 包括增删查改四个功能
 */
public class GoodsManagerService {

	// 用户发布一个物品
	public int addGoods(String goodsName, String goodsDescription, String goodsImage, String goodsReleaseTime,
			String goodsDegree, String goodsType, String userEmail) {

		GoodsManagerDao goodsManagerDao = new GoodsManagerDao();
		int i = goodsManagerDao.addGoods(goodsName, goodsDescription, goodsImage, goodsReleaseTime, goodsDegree,
				goodsType, userEmail);
		return i;
	}

	// 根据物品Id查询一个物品
	public Goods selectOneGoodsById(int goodsId) throws SQLException {
		Goods goods = new Goods();
		GoodsManagerDao goodsManagerDao = new GoodsManagerDao();
		goods = goodsManagerDao.selectOneGoodsById(goodsId);
		return goods;

	}

	// 根据物品名称模糊查询查询物品
	public ArrayList<Goods> selectOneGoodsByGoodsName(String goodsName, int currentPage, int pageSize) throws SQLException {
		GoodsManagerDao goodsManagerDao = new GoodsManagerDao();
		ArrayList<Goods> goodsList = goodsManagerDao.selectOneGoodsByGoodsName(goodsName, currentPage, pageSize);
		return goodsList;
	}

	// 根据用户邮箱查询该用户发布的所有物品
	public ArrayList<Goods> selectOneGoodsByUserEmail(String userEmail) throws SQLException {

		GoodsManagerDao goodsManagerDao = new GoodsManagerDao();
		ArrayList<Goods> goodsList = goodsManagerDao.selectAllGoodsByUserEmail(userEmail);
		return goodsList;
	}

	// 根据物品类型查询物品
	public ArrayList<Goods> selectOneGoodsByGoodsType(String goodsType, int currentPage, int pageSize) throws SQLException {

		GoodsManagerDao goodsManagerDao = new GoodsManagerDao();
		ArrayList<Goods> goodsList = goodsManagerDao.selectOneGoodsByGoodsType(goodsType, currentPage, pageSize);
		return goodsList;
	}

	// 查询所有的物品，这是根据物品状态来决定的
	public ArrayList<Goods> selectAllGoodsByGoodsStatus(int goodsStatus) throws SQLException {
		GoodsManagerDao goodsManagerDao = new GoodsManagerDao();
		ArrayList<Goods> goodsList = goodsManagerDao.selectAllGoodsByGoodsStatus(goodsStatus);
		return goodsList;

	}

	// 根据物品Id删除一个物品
	public int deleteOneGoodsById(int goodsId) {
		GoodsManagerDao goodsManagerDao = new GoodsManagerDao();
		int i = goodsManagerDao.deleteOneGoodsById(goodsId);
		return i;

	}

	// 根据物品Id进行物品信息的修改
	public int updateOneGoodsById(int goodsId, String goodsName, String goodsDescription) {
		GoodsManagerDao goodsManagerDao = new GoodsManagerDao();
		int i = goodsManagerDao.updateOneGoodsById(goodsId, goodsName, goodsDescription);
		return i;
	}

	// 根据物品Id更新物品的状态为1，表示审核通过
	public int updateGoodsStatusByGoodsId(int goodsId) {
		GoodsManagerDao goodsManagerDao = new GoodsManagerDao();
		int i = goodsManagerDao.updateGoodsStatusByGoodsId(goodsId);
		return i;
	}
	
	// 统计共有多少个物品（goods表共有多少条记录）
	public int getTotalRecord() throws SQLException {
		GoodsManagerDao goodsManagerDao = new GoodsManagerDao();
		int i =  goodsManagerDao.getTotalRecord();
		return i;
	}
	
	// 统计共有多少个物品（goods表共有多少条记录）当物品有类型时
	public int getTotalRecordByGoodsType(String goodsType) throws SQLException {
		GoodsManagerDao goodsManagerDao = new GoodsManagerDao();
		int i =  goodsManagerDao.getTotalRecordByGoodsType(goodsType);
		return i;
	}
	
	// 统计共有多少个物品（goods表共有多少条记录）当通过物品名进行模糊搜索时
	public int getTotalRecordByLIkeGoodsName(String goodsName) throws SQLException {
		GoodsManagerDao goodsManagerDao = new GoodsManagerDao();
		int i =  goodsManagerDao.getTotalRecordByLIkeGoodsName(goodsName);
		return i;
	}
	
	//查询某一页的物品数据集合,这是所有物品的分页数据处理
	// currentPage表示当前页（页码），pageSize表示每页显示多少数据
	public ArrayList<Goods> selectAllGoodsByPage(int currentPage, int pageSize) throws SQLException{
		GoodsManagerDao goodsManagerDao = new GoodsManagerDao();
		ArrayList<Goods> goodsList = goodsManagerDao.selectAllGoodsByPage(currentPage, pageSize);
		return goodsList;
	}

}
