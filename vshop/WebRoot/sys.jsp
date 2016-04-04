<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
 %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>无限级分销管理系统</title>
<!-- Bootstrap -->
<link href="bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style type="text/css">
body {
	padding: 70px;
}

.table {
	width: 70%;
	margin: 0px auto;
	margin-top: 30px;
}

.input {
	width: 150px;
	border: 1px solid #eee;
	height: 40px;
	line-height: 40px;
	border-radius: 3px;
	padding-left: 10px;
}
.succsysmsg{
	font-size: 20px;
	color: green;
}
.failsysmsg{
	font-size: 20px;
	color: red;
}
</style>
</head>
<body>

	<!-- 引入我们的头部文件 -->
	<%@ include file="head.jsp"%>
	<div class="container-fluid ">
	<form action="<%=path %>/sys.do?m=saveSys" method = "post">
		<table class="table table-hover table-bordered">
			<tr>
				<th colspan="2" style="text-align: center; font-size: 16px;">系统设置</th>
			</tr>
			<tr>
				<td align="right" style="vertical-align: middle;">A级会员：</td>
				<td style="vertical-align: middle;"><input type="text"
					class=" input" placeholder="设置最小人数" name="one_user_min" value="${sys_one.user_min }" />&nbsp;-&nbsp;<input
					class=" input" type="text" placeholder="设置最大人数" name="one_user_max"  value="${sys_one.user_max }" />&nbsp;&yen;&nbsp;<input
					class=" input" type="text" placeholder="设置奖金" name="one_user_money"  value="${sys_one.user_money }"/>
					<input type="hidden" name="one_id" value="${sys_one.id }"/>
					</td>
			</tr>
			<tr>
				<td align="right" style="vertical-align: middle;">B级会员：</td>
				<td style="vertical-align: middle;"><input type="text"
					class=" input" placeholder="设置最小人数" name="two_user_min" value="${sys_two.user_min }" />&nbsp;-&nbsp;<input
					class=" input" type="text" placeholder="设置最大人数" name="two_user_max" value="${sys_two.user_max }" />&nbsp;&yen;&nbsp;<input
					class=" input" type="text" placeholder="设置奖金" name="two_user_money" value="${sys_two.user_money }" />
					<input type="hidden" name="two_id" value="${sys_two.id }"/></td>
			</tr>
			<tr>
				<td align="right" style="vertical-align: middle;">C级会员：</td>
				<td style="vertical-align: middle;"><input type="text"
					class=" input" placeholder="设置最小人数" name="three_user_min" value="${sys_three.user_min }" />&nbsp;-&nbsp;<input
					class=" input" type="text" placeholder="设置最大人数"  name="three_user_max"  value="${sys_three.user_max }" />&nbsp;&yen;&nbsp;<input
					class=" input" type="text" placeholder="设置奖金" name="three_user_money" value="${sys_three.user_money }" />
					<input type="hidden" name="three_id" value="${sys_three.id }"/></td>
			</tr>
			<tr>
				<td align="right" style="vertical-align: middle;">D级会员：</td>
				<td style="vertical-align: middle;"><input type="text"
					class=" input" placeholder="设置最小人数" name="four_user_min" value="${sys_four.user_min }" />&nbsp;-&nbsp;<input
					class=" input" type="text" placeholder="设置最大人数"  name="four_user_max" value="${sys_four.user_max }" />&nbsp;&yen;&nbsp;<input
					class=" input" type="text" placeholder="设置奖金" name="four_user_money" value="${sys_four.user_money }" />
					<input type="hidden" name="four_id" value="${sys_four.id }"/></td>
			</tr>
			<tr>
				<td align="right" style="vertical-align: middle;">E级会员：</td>
				<td style="vertical-align: middle;"><input type="text"
					class=" input" placeholder="设置最小人数" name="five_user_min" value="${sys_five.user_min }" />&nbsp;-&nbsp;<input
					class=" input" type="text" placeholder="设置最大人数" name="five_user_max" value="${sys_five.user_max }" />&nbsp;&yen;&nbsp;<input
					class=" input" type="text" placeholder="设置奖金" name="five_user_money" value="${sys_five.user_money }" />
					<input type="hidden" name="five_id" value="${sys_five.id }"/></td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<button class="btn  btn-primary" type="submit">提交保存</button>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<span id="savesysmsg">${savesysMsg }</span>
				</td>
			</tr>
		</table>
		</form>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.2.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap-3.3.5/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			var savesysmsg = $("#savesysmsg");
			if(savesysmsg.val().indexOf("成功")){
				savesysmsg.addClass("succsysmsg");
			}else{
				savesysmsg.addClass("failsysmsg");
			}
		});
	</script>
</body>
</html>