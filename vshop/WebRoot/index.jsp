<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java无限级分销管理系统</title>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<link rel="stylesheet" href="css/reset.css" type="text/css">
<link rel="stylesheet" href="css/login.css" type="text/css">
</head>

<body>
	<div class="wrapper">
		<div class="admin_login_main">
			<div class="admin_login_logo">无限级分销管理系统</div>
			<div class="admin_login_wrap">
				<input id="account" class="admin_login_name inputs" type="text"
					value="" /> <input id="password" type="password"
					class="admin_login_pwd inputs" value="" autocomplete="off" />
				<div class="tips_wrap">
					<span class="tips">
					<a href="getpass.jsp">忘记密码？</a> 
					</span>
					<button type="submit" class="admin_login_btn"></button>
					<span class="link_pwd"></span>
				</div>
			</div>
		</div>
	</div>

	<div id="Bottom">&copy;alison 2015</div>
	<script type="text/javascript"
		src="<%=path%>/js/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" >
	$(function() {

	$(".admin_login_btn").click(function() {
		var account = $("#account");
		var password = $("#password");
		if (account.val() == "") {
			account.focus();
			$(".link_pwd").html("用户名不能为空!");
			return false;
		}
		if (password.val() == "") {
			password.focus();
			$(".link_pwd").html("密码不能为空!");
			return false;
		}

		$.ajax({
			url : "login.do",
			type : "POST",
			data : {
				"account":account.val(),
				"password":password.val(),
				"time":new Date().getTime()
			},
			dataType:"json",
			success : function(msg) {
				if (msg == 1) {
					$(".link_pwd").html("用户名错误");
					return false;
				} else if (msg == 2) {
					$(".link_pwd").html("密码错误");
					return false;
				} else if (msg == 3) {
					// 正确
					location.href = 'main.do';
				}
			},
			error : function(er) {
				console.log(er);
			}
		});

	});
});
	</script>
</body>
</html>