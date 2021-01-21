package com.barter.pojo;

public class Announcement {
	private int announcementId;
	private String announcementContent;
	private String announcementTime;
	private int announcementStatus;
	private String userEmail;
	public int getAnnouncementId() {
		return announcementId;
	}
	public void setAnnouncementId(int announcementId) {
		this.announcementId = announcementId;
	}
	public String getAnnouncementContent() {
		return announcementContent;
	}
	public void setAnnouncementContent(String announcementContent) {
		this.announcementContent = announcementContent;
	}
	public String getAnnouncementTime() {
		return announcementTime;
	}
	public void setAnnouncementTime(String announcementTime) {
		this.announcementTime = announcementTime;
	}
	public int getAnnouncementStatus() {
		return announcementStatus;
	}
	public void setAnnouncementStatus(int announcementStatus) {
		this.announcementStatus = announcementStatus;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
