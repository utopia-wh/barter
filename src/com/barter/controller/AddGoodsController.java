package com.barter.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.barter.service.GoodsManagerService;

@SuppressWarnings("serial")
@MultipartConfig
@WebServlet("/AddGoodsController")
/*
 * 上传一个物品的控制层
 */
public class AddGoodsController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		//获取上传者的用户邮箱
		String userEmail = req.getParameter("userEmail");
		if(userEmail.equals("")) {
			req.setAttribute("status", 1);
			req.getRequestDispatcher("addGoods.jsp").forward(req, resp);
			return;
		}
		// 物品名称
		String goodsName = req.getParameter("goodsName");
		//物品类型
		String goodsType = req.getParameter("goodsType");
		// 新旧程度
		String goodsDegree = req.getParameter("goodsDegree");
		//物品描述
		String goodsDescription = req.getParameter("goodsDescription");
		// 获取上传的头像图片
		Part goodsImageTemp = req.getPart("goodsImage");
		// 获取上传文件的文件名称
		String fileName = goodsImageTemp.getSubmittedFileName();
		System.out.println(fileName);
		// 准备给图片重命名，但是不能改变图片的后缀
		// 先获取上传文件的后缀名
		String postfixName = fileName.substring(fileName.indexOf("."));
		System.out.println(postfixName);
		// 获取当前时间给图片起个新名
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		// 重组名字,存入数据的文件名
		String goodsImage = simpleDateFormat.format(new Date()) + postfixName;
		System.out.println(goodsImage);
		// 开始保存图片
		// 将图片保存在项目中对应的文件夹内
		String savePath = "E:\\GraduationProject\\workspace\\barter\\WebContent\\goodsImages";
		// 将照片文件写入goodsImages目录下保存
		goodsImageTemp.write(savePath + "\\" + goodsImage);
		//获取当前时间为物品发布时间
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy年MM月dd日HH时");
		String goodsReleaseTime = simpleDateFormat1.format(new Date());
		
		System.out.println("...................");
		System.out.println(goodsName);
		System.out.println(goodsType);
		System.out.println(goodsDegree);
		System.out.println(goodsDescription);
		System.out.println(savePath + "\\" + goodsImage);
		System.out.println(goodsReleaseTime);
		System.out.println("...................");
		
		GoodsManagerService goodsManagerService = new GoodsManagerService();
		int i = goodsManagerService.addGoods(goodsName, goodsDescription, goodsImage, goodsReleaseTime, goodsDegree, goodsType, userEmail);
		if(i>0) {
			req.setAttribute("status", 2);
			req.getRequestDispatcher("addGoods.jsp").forward(req, resp);
			
		}
		else {
			req.setAttribute("status", 3);
			req.getRequestDispatcher("addGoods.jsp").forward(req, resp);
		}
	}

}
