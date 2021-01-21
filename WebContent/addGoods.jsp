<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传物品</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
	type="text/css" />
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/jquery.dropdown.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
		var status ='<%=request.getAttribute("status")%>';
		if (status == 1) {
			alert("请先登录");
		}
		if (status == 2) {
			alert("上传成功");
		}
		if (status ==3) {
			alert("上传失败");
		}
	
</script>
</head>
<body
	style="background-image: url(backgroundImages/loginBackground.jpg); background-size: 100%">
	<div class="container">
		<div class="navbar navbar-default navbar-fixed-top" role="navigation">
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation"
				style="margin-left: 200px; margin-right: 150px;">
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="QueryAllGoodsByPage?goodsType=all">所有物品</a></li>
						<li><a href="QueryAllGoodsByPage?goodsType=电子产品">电子产品</a></li>
						<li><a href="QueryAllGoodsByPage?goodsType=生活用品">生活用品</a></li>
						<li><a href="QueryAllGoodsByPage?goodsType=体育用品">体育用品</a></li>
						<li><a href="QueryAllGoodsByPage?goodsType=手工品">手工品</a></li>
						<li><a href="QueryAllGoodsByPage?goodsType=服装">服装</a></li>
						<li><a href="QueryAllGoodsByPage?goodsType=书籍">书籍</a></li>
						<li><a href="QueryAllGoodsByPage?goodsType=其他">其他</a></li>
					</ul>
					<form class="navbar-form navbar-left" role="search"
						action="SelectGoodsLikeGoodsNameController" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="keyWord" />
						</div>
						<button type="submit" class="btn btn-default">搜索</button>
					</form>
					<ul class="nav navbar-nav">

						<%
							if (session.getAttribute("user") != null) {
						%>
						<li><img alt="" width=50px height=50px
							src="userImages/${sessionScope.user.userImage}"></li>
						<li><a href="#">${sessionScope.user.userName}</a></li>
						<li><a href="signOut.jsp">退出</a></li>
						<%
							} else {
						%>
						<li><a href="login.jsp">登录</a></li>
						<li><a href="register.jsp">注册</a></li>

						<%
							}
						%>

						<!-- 根据用户权限的不同设置管理中心 或者个人中心-->
						<c:choose>
							<c:when test="${user.permissionLevel==2}">
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">管理中心<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li><a href="sendMessge.jsp">发消息</a></li>
										<li><a
											href="SelectAllCheckedGoodsController?goodsStatus=1">已审核</a>
										</li>
										<li><a
											href="SelectAllCheckedGoodsController?goodsStatus=0">待审核</a>
										</li>
										<li><a href="SelectAllUserController">用户管理</a></li>
										<li><a href="addAnnouncement.jsp">发布公告</a></li>
										<li><a href="SelectAllAnnouncementController">管理公告</a></li>
										<li><a
											href="SelectAllSendMessageController?userEmail=${user.userEmail}">发出的消息</a>
										</li>
										<li><a
											href="SelectAllReceiveMessageController?userEmail=${user.userEmail}">收到的消息</a>
										</li>

									</ul></li>
							</c:when>
							<c:otherwise>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">个人中心<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li><a href="sendMessge.jsp">发消息</a></li>
										<li><a href="addGoods.jsp">上传物品</a></li>
										<li><a
											href="SelectAllGoodsByUserEmailController?userEmail=${user.userEmail}">我的上传</a>
										</li>
										<li><a
											href="SelectAllCollectController?userId=${user.userId}">我的收藏</a>

										</li>
										<li><a href="SelectAllAnnouncementController">查看公告</a></li>
										<li><a
											href="SelectOneUserController?userId=${user.userId}">个人信息</a>
										</li>
										<li><a
											href="SelectAllSendMessageController?userEmail=${user.userEmail}">发出的消息</a>
										</li>
										<li><a
											href="SelectAllReceiveMessageController?userEmail=${user.userEmail}">收到的消息</a>
										</li>
										<li><a
											href="SelectAllSendExchangeController?userEmail=${user.userEmail}">发出的换物请求</a></li>
										<li><a
											href="SelectAllReceiveExchangeController?userEmail=${user.userEmail}">收到的换物请求</a></li>
										<li><a href="updatePersonageInfo.jsp">个人信息修改</a></li>
									</ul></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>

			</nav>
		</div>
		<div style="height: 100px;"></div>
		<form class="form-horizontal"
			action="AddGoodsController?userEmail=${user.userEmail}" method="post"
			enctype="multipart/form-data">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">物品名称</label>
				<div class="col-sm-3">
					<input type="text" class="form-control" id="inputEmail3"
						placeholder="请输入物品名称" name="goodsName">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">物品类型</label>
				<div class="col-sm-3">
					<select class="form-control" name="goodsType">
						<option>其他</option>
						<option>书籍</option>
						<option>服装</option>
						<option>手工品</option>
						<option>体育用品</option>
						<option>生活用品</option>
						<option>电子产品</option>
					</select>
					<p class="help-block">选择后不可更改</p>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">新旧程度</label>
				<div class="col-sm-3">
					<select class="form-control" name="goodsDegree">
						<option>其他</option>
						<option>九成新</option>
						<option>八成新</option>
						<option>七成新</option>
						<option>六层新</option>
						<option>五层新</option>
					</select>
					<p class="help-block">选择后不可更改</p>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">物品描述</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="5" placeholder="添加物品描述"
						style="width: 500px;" name="goodsDescription"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">上传照片</label>
				<div class="col-sm-3">
					<input type="file" id="exampleInputFile" name="goodsImage">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">上传物品</button>
				</div>
			</div>
		</form>
	</div>


</body>
</html>