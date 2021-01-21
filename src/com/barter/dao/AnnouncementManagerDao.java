package com.barter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.barter.dbhelper.DBHelper;
import com.barter.pojo.Announcement;

/*
 * 公告管理dao层
 * 包括增删查三个功能
 */
public class AnnouncementManagerDao {
	DBHelper db = new DBHelper();

	//增加一个公告
	public int addAnnouncement(String userEmail, String announcementContent, String announcementTime) {
		String sql = "insert into announcement (userEmail, announcementContent, announcementTime) values (?,?,?)";
		int i = db.executeUpdate(sql, userEmail, announcementContent, announcementTime);
		return i;
	}

	//根据公告Id查询公告信息
	public Announcement selectOneAnnouncementById(int announcementId) throws SQLException {
		Announcement announcement = new Announcement();
		String sql = "select * from announcement where announcementId=?";
		ResultSet rs = null;
		rs = db.executeQuery(sql, announcementId);
		rs.next();
	    announcement.setAnnouncementId(rs.getInt("announcementId"));
	    announcement.setAnnouncementContent(rs.getString("announcementContent"));
	    announcement.setAnnouncementTime(rs.getString("announcementTime"));
	    announcement.setAnnouncementStatus(rs.getInt("announcementStatus"));
	    announcement.setUserEmail(rs.getString("userEmail"));
	    return announcement;	
	}

	//查询所有的公告
	public ArrayList<Announcement> selectAllAnnouncement() throws SQLException {
		ArrayList<Announcement> announcementList = new ArrayList<Announcement>();
		Announcement announcement = new Announcement();
		String sql = "select * from announcement order by announcementId desc";
		ResultSet rs = null;
		rs = db.executeQuery(sql);
		while(rs.next()) {
			announcement = new Announcement();
			announcement.setAnnouncementId(rs.getInt("announcementId"));
		    announcement.setAnnouncementContent(rs.getString("announcementContent"));
		    announcement.setAnnouncementTime(rs.getString("announcementTime"));
		    announcement.setAnnouncementStatus(rs.getInt("announcementStatus"));
		    announcement.setUserEmail(rs.getString("userEmail"));
		    announcementList.add(announcement);
		}
		return announcementList;
	}

	//根据公告Id删除公告
	public int deleteOneAnnouncementById(int announcementId) {
		String sql = "delete from announcement where announcementId=?";
		int i = db.executeUpdate(sql, announcementId);
		return i;
	}
}
