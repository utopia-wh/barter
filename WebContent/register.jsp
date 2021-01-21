<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"
	type="text/css" />
<link rel="stylesheet" href="css/register.css" type="text/css" />
<script type="text/javascript">
		var registerStatus ='<%=request.getAttribute("registerStatus")%>';
	if (registerStatus == 1) {
		alert("该邮箱已被使用");
	}
	if (registerStatus == 3) {
		alert("注册失败");
	}
</script>
</head>
<body
	style="background-image: url(backgroundImages/loginBackground.jpg); background-size: 1000%">
	<div class="container">
		<div
			style="height: 100px; text-align: center; font-size: 40px; margin-bottom: 20px; margin-top: 50px;">
			<b><i>用户注册</i></b>
		</div>
		<div style="margin-left: 260px;">
			<form class="form-horizontal" action="UserRegisterController"
				method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">邮箱</label>
					<div class="col-sm-4">
						<input type="email" class="form-control" id="inputEmail3"
							placeholder="请输入邮箱" name="userEmail">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" id="inputPassword3"
							placeholder="请输入密码" name="userPassword">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="inputPassword3"
							placeholder="请输入真实名字" name="userName">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">用户电话</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="inputPassword3"
							placeholder="请输入电话号码" name="userTelephone">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">地址</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="inputPassword3"
							placeholder="XX省XX市" name="userAddress">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">性别</label>
					<div class="col-sm-3">
						<select class="form-control" name="userSex">
							<option>男</option>
							<option>女</option>
						</select>
						<p class="help-block">选择后不可更改</p>
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">上传头像</label>
					<div class="col-sm-3">
						<input type="file" id="exampleInputFile" name="userImage">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">注册</button>
						<a href="login.jsp"><button type="button"
								class="btn btn-default">返回登陆</button></a>
					</div>
				</div>

			</form>
		</div>
	</div>
</body>
</html>