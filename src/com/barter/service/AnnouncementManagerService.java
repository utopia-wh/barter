package com.barter.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.barter.dao.AnnouncementManagerDao;
import com.barter.pojo.Announcement;

/*
 * 公告管理service层
 * 包括增删查改四个功能
 */
public class AnnouncementManagerService {

	//发布一个公告
	public int addAnnouncement(String userEmail, String announcementContent, String announcementTime) {
		AnnouncementManagerDao announcementManagerDao = new AnnouncementManagerDao();
		int i = announcementManagerDao.addAnnouncement(userEmail, announcementContent, announcementTime);
		return i;
	}
	
	//根据公告Id查询公告
	public Announcement selectOneAnnouncementById(int announcementId) throws SQLException {
		AnnouncementManagerDao announcementManagerDao = new AnnouncementManagerDao();
        Announcement announcement = new Announcement();
		announcement = announcementManagerDao.selectOneAnnouncementById(announcementId);
		return announcement;
	}

	//查询所有的公告
	public ArrayList<Announcement> selectAllAnnouncement() throws SQLException {
		ArrayList<Announcement> announcementList = new ArrayList<Announcement>();
		AnnouncementManagerDao announcementManagerService = new AnnouncementManagerDao();
		announcementList = announcementManagerService.selectAllAnnouncement();
		return announcementList;
	}

	//根据公告Id删除公告
	public int deleteOneAnnouncementById(int announcementId) {
		AnnouncementManagerDao announcementManagerDao = new AnnouncementManagerDao();
		int i = announcementManagerDao.deleteOneAnnouncementById(announcementId);
		return i;
	}

}
