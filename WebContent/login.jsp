<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>用户登录</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css"/>
	<link rel="stylesheet" href="css/login.css" type="text/css"/>
	<script type="text/javascript">
		var message ='<%=request.getAttribute("loginError")%>';
		var updateInfoStatus ='<%=request.getAttribute("updateInfoStatus")%>';
		var registerStatus ='<%=request.getAttribute("registerStatus")%>';
		var updatePS ='<%=request.getAttribute("updatePS")%>';
		if (registerStatus == 2) {
			alert("注册成功, 欢迎使用!");
		}
		if(updateInfoStatus==1){
			alert("修改个人信息成功, 请重新登录!")
		}
		if(message==3){
			alert("邮箱或密码错误！");
		}
		if(message==2){
			alert("邮箱或手机号为空")
		}
		if(updatePS==1){
			alert("修改密码成功")
		}
		if(updatePS==2){
			alert("修改密码失败")
		}
		</script>
	
</head>


<body style="background-image: url(backgroundImages/loginBackground.jpg); background-size: 100%">


<div class="login" style="align-content: center;">
  <div style="height:100px; text-align: center; font-size: 40px; margin-bottom: 30px"><b><i>欢迎使用换物网</i></b></div>
  <div style="margin-left: 210px">
		<form class="form-horizontal" action="SelectOneUserController" method="post">
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
		    <div class="col-sm-5">
		      <input type="email" class="form-control" id="inputEmail3" placeholder="请输入邮箱" name="userEmail">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
		    <div class="col-sm-5">
		      <input type="password" class="form-control" id="inputPassword3" placeholder="请输入密码" name="userPassword">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-default">登录</button>
		      <a href="register.jsp"><button type="button" class="btn btn-default">去注册</button></a>
		      <a href="verifyEmailAndTelephone.jsp"><button type="button" class="btn btn-default">忘记密码</button></a>
		    </div>
		  </div>
		</form>
	</div>
</div>
</body>
</html>