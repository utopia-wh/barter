package com.barter.util;

import java.util.ArrayList;

import com.barter.pojo.Goods;

/*
 * 物品分页工具类
 */
public class GoodsPageManager {
	// 当前页
	private int currentPage;
	// 当前页的数据集合
	private ArrayList<Goods> goodsList;
	// 总共有多少条数据
	private int totalRecord;
	// 每页显示几条数据
	private int pageSize;
	// 共有多少页
	private int totalPage;
	//物品类型
	private String goodsType;
	//物品名称
	private String goodsName;
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public ArrayList<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(ArrayList<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.totalPage = this.totalRecord%this.pageSize==0?this.totalRecord/this.pageSize : this.totalRecord/this.pageSize+1;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	

//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
	

}
