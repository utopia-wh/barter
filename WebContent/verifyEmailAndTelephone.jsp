<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>验证手机号</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet" href="css/login.css" type="text/css" />
<script type="text/javascript">
		var verify ='<%=request.getAttribute("verify")%>';
	if (verify == 1) {
		alert("邮箱或密码为空");
	}
	if (verify == 3) {
		alert("手机号错误")
	}
</script>
</head>
<body
	style="background-image: url(backgroundImages/loginBackground.jpg); background-size: 100%">
	<div class="login" style="align-content: center;">
		<div
			style="height: 100px; text-align: center; font-size: 40px; margin-bottom: 30px">
			<b><i>①验证邮箱和手机号</i></b>
		</div>
		<div style="margin-left: 210px">
			<form class="form-horizontal" action="VerifyEmailAndTelephoneController"
				method="post">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
					<div class="col-sm-5">
						<input type="email" class="form-control" id="inputEmail3"
							placeholder="填写邮箱账号" name="userEmail">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">手机号</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="inputEmail3"
							placeholder="注册时填写的手机号码" name="userTelephone">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<a href="login.jsp"><button type="button"
								class="btn btn-default">返回登陆</button></a> 
							<button type="submit" class="btn btn-default">验证</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>