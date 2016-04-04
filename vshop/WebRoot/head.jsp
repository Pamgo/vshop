<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse  navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a href="#" class="navbar-brand active" style="color: #fff;">无限级分销系统</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.do">我的分销</a></li>
				<li><a href="info.do">会员中心</a></li>
				<li><a href="sys.do">系统设置</a></li>
				<li><a href="out.jsp">安全退出</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right hidden-sm">
				<li><a style="color: #fff;" href="main.do">欢迎您：${sessionScope.username }(系统管理员)</a></li>
			</ul>

		</div>
	</div>
</nav>