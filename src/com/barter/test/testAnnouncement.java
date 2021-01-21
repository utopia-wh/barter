package com.barter.test;

import java.sql.SQLException;

import com.barter.dao.AnnouncementManagerDao;

public class testAnnouncement {
	public static void main(String[] args) throws SQLException {
		AnnouncementManagerDao am = new AnnouncementManagerDao();
		//System.out.println(am.addAnnouncement(1, "测试", "2020年04月25日"));
		System.out.println(am.selectOneAnnouncementById(1).getAnnouncementContent());
	}

}
