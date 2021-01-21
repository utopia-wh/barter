<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>修改密码</title>
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css"/>
	<link rel="stylesheet" href="css/login.css" type="text/css"/>
	<script type="text/javascript">{
		var verify ='<%=request.getAttribute("verify")%>';
	if (verify == 3) {
		alert("验证成功");
	}
	}
</script>
</head>
<body style="background-image: url(backgroundImages/loginBackground.jpg); background-size: 100%">
<div class="login" style="align-content: center;">
  <div style="height:100px; text-align: center; font-size: 40px; margin-bottom: 30px"><b><i>②修改密码</i></b></div>
  <div style="margin-left: 210px">
		<form class="form-horizontal" action="UpdateUserPasswordByTelephoneController?userTelephone=${user.userTelephone}" method="post">
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">新密码</label>
		    <div class="col-sm-5">
		      <input type="text" class="form-control" id="inputEmail3" placeholder="输入新密码" name="userPassword">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		       <a href="login.jsp"><button type="button" class="btn btn-default">返回登陆</button></a>
		      <button type="submit" class="btn btn-default">修改</button> 
		    </div>
		  </div>
		</form>
	</div>
</div>
</body>
</html>