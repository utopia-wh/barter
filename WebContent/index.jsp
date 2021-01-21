<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>换物网</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
	type="text/css" />
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/jquery.dropdown.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
		var exchangeStatus ='<%=request.getAttribute("exchangeStatus")%>';
		var updateInfoStatus ='<%=request.getAttribute("updateInfoStatus")%>';
		var collectStatus ='<%=request.getAttribute("collectStatus")%>';
	if (collectStatus == 1) {
		alert("收藏成功");
	}
	if (collectStatus == 2) {
		alert("收藏失败");
	}
	if (collectStatus == 3) {
		alert("你收藏自己上传的物品没有意义啊");
	}
	if (collectStatus == 4) {
		alert("你已收藏过该物品");
	}
	if (updateInfoStatus == 2) {
		alert("修改个人信息失败, 请稍后尝试!")
	}
	if (exchangeStatus == 1) {
		alert("发送请求成功");
	}
	if (exchangeStatus == 2) {
		alert("发送请求失败");
	}
</script>


</head>
<body
	style="background-image: url(backgroundImages/loginBackground.jpg); background-size: 1000%">
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
		<div style="height: 70px;"></div>
		<c:forEach items="${goodsPageManager.goodsList}" var="goods">
			<div class="thumbnail"
				style="width: 350px; float: left; height: 280px; margin-left: 30px; background: #D1EEEE;">
				<img alt="150x100" style="width: 150px; height: 90px"
					src="goodsImages/${goods.goodsImage}" />
				<div class="caption">
					<h3>${goods.goodsName}</h3>
					<p>${goods.goodsDescription}</p>
					<div style="margin-bottom: 5px;">
						<p>
							<a class="btn btn-primary"
								href="QueryOneGoodsByGoodsIdController?goodsId=${goods.goodsId}">查看详情</a>
						</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	<div style="margin-left: 35%;">
		<nav aria-label="Page navigation">
			-
			<c:if test="${goodsPageManager.goodsName == null}">
				<ul class="pagination pagination-lg">
					<li><a
						href="QueryAllGoodsByPage?currentPage=1&goodsType=${goodsPageManager.goodsType}">首页</a></li>
					<c:choose>
						<c:when
							test="${goodsPageManager.currentPage==1&&goodsPageManager.totalPage>1}">
							<li><a
								href="QueryAllGoodsByPage?currentPage=${goodsPageManager.currentPage+1}&goodsType=${goodsPageManager.goodsType}">下一页</a></li>
						</c:when>
						<c:when
							test="${goodsPageManager.currentPage==goodsPageManager.totalPage&&goodsPageManager.totalPage>1}">
							<li><a
								href="QueryAllGoodsByPage?currentPage=${goodsPageManager.currentPage-1}&goodsType=${goodsPageManager.goodsType}">上一页</a></li>
						</c:when>
						<c:when
							test="${goodsPageManager.currentPage>1&&goodsPageManager.totalPage>1&&goodsPageManager.currentPage<goodsPageManager.totalPage}">
							<li><a
								href="QueryAllGoodsByPage?currentPage=${goodsPageManager.currentPage-1}&goodsType=${goodsPageManager.goodsType}">上一页</a></li>
							<li><a
								href="QueryAllGoodsByPage?currentPage=${goodsPageManager.currentPage+1}&goodsType=${goodsPageManager.goodsType}">下一页</a></li>
						</c:when>
					</c:choose>
					<li><a
						href="QueryAllGoodsByPage?currentPage=${goodsPageManager.totalPage}&goodsType=${goodsPageManager.goodsType}">尾页</a></li>
					<li><a href="#">第${goodsPageManager.currentPage}/${goodsPageManager.totalPage}页</a></li>
				</ul>
			</c:if>


			<c:if test="${goodsPageManager.goodsName != null}">
				<ul class="pagination pagination-lg">
					<li><a
						href="SelectGoodsLikeGoodsNameController?currentPage=1&keyWord=${goodsPageManager.goodsName}">首页</a></li>
					<c:choose>
						<c:when
							test="${goodsPageManager.currentPage==1&&goodsPageManager.totalPage>1}">
							<li><a
								href="SelectGoodsLikeGoodsNameController?currentPage=${goodsPageManager.currentPage+1}&keyWord=${goodsPageManager.goodsName}">下一页</a></li>
						</c:when>
						<c:when
							test="${goodsPageManager.currentPage==goodsPageManager.totalPage&&goodsPageManager.totalPage>1}">
							<li><a
								href="SelectGoodsLikeGoodsNameController?currentPage=${goodsPageManager.currentPage-1}&keyWord=${goodsPageManager.goodsName}">上一页</a></li>
						</c:when>
						<c:when
							test="${goodsPageManager.currentPage>1&&goodsPageManager.totalPage>1&&goodsPageManager.currentPage<goodsPageManager.totalPage}">
							<li><a
								href="SelectGoodsLikeGoodsNameController?currentPage=${goodsPageManager.currentPage-1}&keyWord=${goodsPageManager.goodsName}">上一页</a></li>
							<li><a
								href="SelectGoodsLikeGoodsNameController?currentPage=${goodsPageManager.currentPage+1}&keyWord=${goodsPageManager.goodsName}">下一页</a></li>
						</c:when>
					</c:choose>
					<li><a
						href="SelectGoodsLikeGoodsNameController?currentPage=${goodsPageManager.totalPage}&keyWord=${goodsPageManager.goodsName}">尾页</a></li>
					<li><a href="#">第${goodsPageManager.currentPage}/${goodsPageManager.totalPage}页</a></li>
				</ul>
			</c:if>

		</nav>
	</div>
</body>
</html>