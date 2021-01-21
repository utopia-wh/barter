package com.barter.test;

import java.sql.SQLException;


public class Test1 {
	public static void main(String[] args) throws SQLException {
//		UserManagerDao userManagerDao = new UserManagerDao();
//		UserManagerService userManagerService = new UserManagerService();
//		User user = null;
//		String userEmail = "1522034695@qq.com";
//		int userId = 1;
//		user = userManagerDao.selectOneUserById(userId);
//		System.out.println(user.getUserEmail());
		
		//测试是否可以修改个人信息
//		UserManagerDao userManagerDao = new UserManagerDao();
//		String userName = "王昌武";
//		String userTelephone = "18894025524";
//		String userAddress = "甘肃省兰州市";
//		int userId = 1;
//		int i = userManagerDao.UpdateOneUserById(userId, userName, userTelephone, userAddress);
//		System.out.println(i);
		
//		GoodsManagerDao goodsManagerDao = new GoodsManagerDao();
//		ArrayList<Goods> list= goodsManagerDao.selectOneGoodsByGoodsName("手机");
//		if(list.size()!=0)
//			 System.out.println(list.get(0).getGoodsName());
		
//		GoodsManagerDao dao = new GoodsManagerDao();
//		String gN = "荣耀手机";
//		String gd = "这个手机很好用";
//		int  goodsId = 1;
//		int i = dao.updateOneGoodsById(goodsId, gN, gd);
		String content = "电饭煲又称作电锅、电饭锅。是利用电能转变为热能的炊具，具有对食品进行蒸、煮、炖、煲、煨等多种加热操作功能，使用方便、安全可靠。它不但能够把食物做熟，而且能够保温，使用起来清洁卫生，没有污染，省时省力，是家务劳动现代化不可缺少的用具之一。二战时期常见的电饭煲分为保温自动式、定时保温式以及新型的微电脑控制式三类。\r\n" + 
				"世界上第一台电饭煲，是由日本人井深大的东京通讯工程公司发明于1950年代。电饭煲的发明缩减了很多家庭花费在煮饭上的时间，已经成为日常家用电器。";
		System.out.println(content.substring(0, 20)+"...");
		


	}

}
