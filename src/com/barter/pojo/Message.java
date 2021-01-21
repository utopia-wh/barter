package com.barter.pojo;

public class Message {
	
	private int messageId;
	private String messageContent;
	private String messageSenderEmail;
	private String messageReceiverEmail;
	private String messageTime;
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getMessageSenderEmail() {
		return messageSenderEmail;
	}
	public void setMessageSenderEmail(String messageSenderEmail) {
		this.messageSenderEmail = messageSenderEmail;
	}
	public String getMessageReceiverEmail() {
		return messageReceiverEmail;
	}
	public void setMessageReceiverEmail(String messageReceiverEmail) {
		this.messageReceiverEmail = messageReceiverEmail;
	}
	public String getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}
	
	

}
