package com.barter.pojo;

public class Exchange {
	
	private int exchangeId;
	private String exchangeSenderEmail;
	private String exchangeReceiverEmail;
	private int exchangeSenderGoodId;
	private int exchangeReceiverGoodsId;
	private String exchangeStatus;
	private String exchangeReason;
	private String exchangeTime;
	private int senderVisible;
	private int receiverVisible;
	public int getExchangeId() {
		return exchangeId;
	}
	public void setExchangeId(int exchangeId) {
		this.exchangeId = exchangeId;
	}
	public String getExchangeSenderEmail() {
		return exchangeSenderEmail;
	}
	public void setExchangeSenderEmail(String exchangeSenderEmail) {
		this.exchangeSenderEmail = exchangeSenderEmail;
	}
	public String getExchangeReceiverEmail() {
		return exchangeReceiverEmail;
	}
	public void setExchangeReceiverEmail(String exchangeReceiverEmail) {
		this.exchangeReceiverEmail = exchangeReceiverEmail;
	}
	public int getExchangeSenderGoodId() {
		return exchangeSenderGoodId;
	}
	public void setExchangeSenderGoodId(int exchangeSenderGoodId) {
		this.exchangeSenderGoodId = exchangeSenderGoodId;
	}
	public int getExchangeReceiverGoodsId() {
		return exchangeReceiverGoodsId;
	}
	public void setExchangeReceiverGoodsId(int exchangeReceiverGoodsId) {
		this.exchangeReceiverGoodsId = exchangeReceiverGoodsId;
	}
	
	public String getExchangeTime() {
		return exchangeTime;
	}
	public void setExchangeTime(String exchangeTime) {
		this.exchangeTime = exchangeTime;
	}
	public String getExchangeStatus() {
		return exchangeStatus;
	}
	public void setExchangeStatus(String exchangeStatus) {
		this.exchangeStatus = exchangeStatus;
	}
	public String getExchangeReason() {
		return exchangeReason;
	}
	public void setExchangeReason(String exchangeReason) {
		this.exchangeReason = exchangeReason;
	}
	public int getSenderVisible() {
		return senderVisible;
	}
	public void setSenderVisible(int senderVisible) {
		this.senderVisible = senderVisible;
	}
	public int getReceiverVisible() {
		return receiverVisible;
	}
	public void setReceiverVisible(int receiverVisible) {
		this.receiverVisible = receiverVisible;
	}
	
	

};

