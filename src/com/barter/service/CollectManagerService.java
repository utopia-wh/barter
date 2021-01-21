package com.barter.service;

import java.sql.SQLException;
import java.util.ArrayList;
import com.barter.dao.CollectManagerDao;
import com.barter.pojo.Collect;
/*
 * 收藏管理service层
 * 包括增删查三个功能
 */
public class CollectManagerService {
	//收藏一个物品
		public int addCollect(int userId, int goodsId, String goodsName, String goodsType, String collectTime) {
			CollectManagerDao collectManagerDao = new CollectManagerDao();
			int i = collectManagerDao.addCollect(userId, goodsId, goodsName, goodsType, collectTime);
			return i;
		}
		
	//根据收藏Id查询收藏
	public Collect selectOneCollectById(int collectId) throws SQLException {
		CollectManagerDao collectManagerDao = new CollectManagerDao();
	    Collect collect = new Collect();
	    collect = collectManagerDao.selectOneCollectById(collectId);
		return collect;
	}

	//查询所有的收藏
	public ArrayList<Collect> selectAllCollect(int userId) throws SQLException {
		ArrayList<Collect> collectList = new ArrayList<Collect>();
		CollectManagerDao collectManagerDao = new CollectManagerDao();
		collectList = collectManagerDao.selectAllCollect(userId);
		return collectList;
	}

	//根据收藏Id删除收藏
	public int deleteOneCollectById(int collectId) {
		CollectManagerDao collectManagerDao = new CollectManagerDao();
		int i = collectManagerDao.deleteOneCollectById(collectId);
		return i;
	}
	
    //判断用户是否已收藏过该物品
	public int selectOneCollected(int userId, int goodsId) throws SQLException {
		CollectManagerDao collectManagerDao = new CollectManagerDao();
		int i = collectManagerDao.selectOneCollected(userId, goodsId);
		return i;
	}
}
