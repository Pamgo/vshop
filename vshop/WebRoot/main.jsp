<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="time" uri="http://www.vshop.com/formattimestamp" %>
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
<title>极客学院-Java无限级分销管理系统</title>
<!-- Bootstrap -->
<link href="bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<link rel="stylesheet" href="css/jquery.jOrgChart.css" />
<link rel="stylesheet" href="css/custom.css" />
<style type="text/css">
body {
	padding: 70px;
}
</style>
</head>
<body>
<!-- 引入我们的头部文件 -->
	<%@ include file="head.jsp"%>
	<div class="container-fluid "
		style="width: 100%; margin: 0 auto; height: 500px; background: url('images/bkgd.png') repeat top left;">
		<div class="main">
			<ul id="org" style="display: none">
				<li>
				<!-- 顶层 -->
					<table border="0" width="100%">
						<tr>
							<td align="center"><img src="images/app5.gif"></td>
						</tr>
						<tr>
							<td align="center">${current_user.user_id }</td>
						</tr>
						<tr>
							<td align="center">
									<%-- ${time:fmtstamp(current_user.created_time,"yyyy-MM-dd") } --%>
									<!-- 自定义标签 -->
									<time:formattimestamp timestamp="${current_user.created_time}" format="yyyy-MM-dd"/>
							</td>
						</tr>
						<tr>
							<td align="center">
								(<fmt:formatNumber type="number" value="${(current_user.right_num-current_user.left_num-1)/2 }"></fmt:formatNumber>)
								<!--添加奖金  -->
								==￥${time:getMoney(current_user.right_num,current_user.left_num)}
							</td>
						</tr>
					</table>
					<!-- 第二层 -->
					<ul>
						<li>
							<table border="0" width="100%" cellpadding="0" cellspacing="0"
								height="60">
								<tr>
									<td align="center"><img src="images/app1.gif"></td>
								</tr>
								<tr>
									<td align="center">
										<c:if test="${user_1 ne null }">
											<a href="<%=path%>/main.do?user_id=${user_1.user_id}">${user_1.user_id}</a>
										</c:if>
										<c:if test="${user_1 eq null }">
											<a href="add.jsp">推荐</a>
										</c:if>
									</td>
								</tr>
								<tr>
									<td align="center">
									<!-- 使用自定义EL表达式 -->
									${time:ELformat(user_1.created_time,"yyyy-MM-dd") }
									</td>
								</tr>
								<tr>
									<td align="center">
									<c:if test="${user_1 ne null }">
									<a href="<%=path%>/user.do?user_id=${user_1.user_id}">查看联系</a>
									</c:if>
									</td>
								</tr>
								<tr>
								<c:if test="${user_1 ne null }">
									<td align="center">
									(<fmt:formatNumber type="number" value="${(user_1.right_num-user_1.left_num - 1)/2 }"></fmt:formatNumber>)
									</td>
								</c:if>
								</tr>
							</table>
							<!-- 第三层 -->
							<ul>
								<li>
									<table border="0" width="100%" cellpadding="0" cellspacing="0"
										height="60">
										<tr>
											<td align="center"><img src="images/app2.gif"></td>
										</tr>
										<tr>
											<td align="center">
											<c:if test="${user_4 ne null }">
												<a href="#">${user_4.user_id }</a>
											</c:if>
											<c:if test="${user_4 eq null }">
											<a href="add.jsp">推荐</a>
											</c:if>
											</td>
										</tr>
										<tr>
											<td align="center">
												<time:formattimestamp timestamp="${user_4.created_time }" format="yyyy-MM-dd"/>
											</td>
										</tr>
										<tr>
											<td align="center">
											<c:if test="${user_4 ne null }">
												<a href="<%=path%>/user.do?user_id=${user_4.user_id}">查看联系</a>
											</c:if>
											</td>
										</tr>
										<tr>
											<c:if test="${user_4 ne null }">
											<td align="center">
											(<fmt:formatNumber type="number" value="${(user_4.right_num - user_4.left_num - 1 ) / 2}" />
											)</td>
											</c:if>
										</tr>
									</table>
								</li>
								<li>
									<table border="0" width="100%" cellpadding="0" cellspacing="0"
										height="60">
										<tr>
											<td align="center"><img src="images/app2.gif"></td>
										</tr>
										<tr>
											<td align="center">
											<c:if test="${user_5 ne null }">
												<a href="#">${user_5.user_id }</a>
											</c:if>
											<c:if test="${user_5 eq null }">
											<a href="add.jsp">推荐1</a>
											</c:if>
											</td>
										</tr>
										<tr>
											<td align="center">
												<time:formattimestamp timestamp="${user_5.created_time }" format="yyyy-MM-dd"/>
											</td>
										</tr>
										<tr>
											<td align="center">
											<c:if test="${user_5 ne null }">
												<a href="<%=path%>/user.do?user_id=${user_5.user_id}">查看联系</a>
											</c:if>
											</td>
										</tr>
										<tr>
											<c:if test="${user_5 ne null }">
											<td align="center">
											(<fmt:formatNumber type="number" value="${(user_5.right_num - user_5.left_num - 1 ) / 2}"/>
											)</td>
											</c:if>
										</tr>
									</table>
								</li>
								<li>
										<table border="0" width="100%" cellpadding="0" cellspacing="0"
										height="60">
										<tr>
											<td align="center"><img src="images/app2.gif"></td>
										</tr>
										<tr>
											<td align="center">
											<c:if test="${user_6 ne null }">
												<a href="#">${user_6.user_id }</a>
											</c:if>
											<c:if test="${user_6 eq null }">
											<a href="add.jsp">推荐2</a>
											</c:if>
											</td>
										</tr>
										<tr>
											<td align="center">
												<time:formattimestamp timestamp="${user_6.created_time }" format="yyyy-MM-dd"/>
											</td>
										</tr>
										<tr>
											<td align="center">
											<c:if test="${user_6 ne null }">
												<a href="<%=path%>/user.do?user_id=${user_6.user_id}">查看联系</a>
											</c:if>
											</td>
										</tr>
										<tr>
											<c:if test="${user_6 ne null }">
											<td align="center">(
											<fmt:formatNumber type="number" value="${(user_6.right_num - user_6.left_num - 1 ) / 2}" />)</td>
											</c:if>
										</tr>
									</table>
								</li>

							</ul>
						</li>
						<!-- 第二层 -->
						<li>
							<table border="0" width="100%" cellpadding="0" cellspacing="0"
								height="60">
								<tr>
									<td align="center"><img src="images/app1.gif"></td>
								</tr>
								<tr>
									<td align="center">
										<c:if test="${user_2 ne null }">
											<a href="#">${user_2.user_id}3</a>
										</c:if>
										<c:if test="${user_2 eq null }">
											<a href="add.jsp">推荐</a>
										</c:if>
									</td>
								</tr>
								<tr>
									<td align="center">
										<time:formattimestamp timestamp="${user_2.created_time }" format="yyyy-MM-dd"/>
									</td>
								</tr>
								<tr>
									<td align="center">
									<c:if test="${user_2 ne null }">
									<a href="<%=path%>/user.do?user_id=${user_2.user_id}">查看联系</a>
									</c:if>
									</td>
								</tr>
								<tr>
								<c:if test="${user_2 ne null }">
									<td align="center">
										(<fmt:formatNumber type="number" value="${(user_2.right_num-user_2.left_num - 1)/2 }"/>)
									</td>
								</c:if>
								</tr>
							</table>
							<!-- 第三层 -->
							<ul>
								<li>
									<table border="0" width="100%" cellpadding="0" cellspacing="0"
										height="60">
										<tr>
											<td align="center"><img src="images/app2.gif"></td>
										</tr>
										<tr>
											<td align="center">
											<c:if test="${user_4 ne null }">
												<a href="#">${user_4.user_id }4</a>
											</c:if>
											<c:if test="${user_4 eq null }">
											<a href="add.jsp">推荐4</a>
											</c:if>
											</td>
										</tr>
										<tr>
											<td align="center">
												<time:formattimestamp timestamp="${user_4.created_time }" format="yyyy-MM-dd"/>
											</td>
										</tr>
										<tr>
											<td align="center">
											<c:if test="${user_4 ne null }">
												<a href="<%=path%>/user.do?user_id=${user_4.user_id}">查看联系</a>
											</c:if>
											</td>
										</tr>
										<tr>
											<c:if test="${user_4 ne null }">
											<td align="center">
											(<fmt:formatNumber type="number" value="${(user_4.right_num - user_4.left_num - 1 ) / 2}" />
											)</td>
											</c:if>
										</tr>
									</table>
								</li>
								<li>
										<table border="0" width="100%" cellpadding="0" cellspacing="0"
										height="60">
										<tr>
											<td align="center"><img src="images/app2.gif"></td>
										</tr>
										<tr>
											<td align="center">
											<c:if test="${user_5 ne null }">
												<a href="#">${user_5.user_id }5</a>
											</c:if>
											<c:if test="${user_5 eq null }">
											<a href="add.jsp">推荐5</a>
											</c:if>
											</td>
										</tr>
										<tr>
											<td align="center">
												<time:formattimestamp timestamp="${user_5.created_time }" format="yyyy-MM-dd"/>
											</td>
										</tr>
										<tr>
											<td align="center">
											<c:if test="${user_5 ne null }">
												<a href="<%=path%>/user.do?user_id=${user_5.user_id}">查看联系</a>
											</c:if>
											</td>
										</tr>
										<tr>
											<c:if test="${user_5 ne null }">
											<td align="center">
											(<fmt:formatNumber type="number" value="${(user_5.right_num - user_5.left_num - 1 ) / 2}"/>)</td>
											</c:if>
										</tr>
									</table>
								</li>
								<li>
										<table border="0" width="100%" cellpadding="0" cellspacing="0"
										height="60">
										<tr>
											<td align="center"><img src="images/app2.gif"></td>
										</tr>
										<tr>
											<td align="center">
											<c:if test="${user_6 ne null }">
												<a href="#">${user_6.user_id }</a>
											</c:if>
											<c:if test="${user_6 eq null }">
											<a href="add.jsp">推荐</a>
											</c:if>
											</td>
										</tr>
										<tr>
											<td align="center">
												<time:formattimestamp timestamp="${user_6.created_time }" format="yyyy-MM-dd"/>
											</td>
										</tr>
										<tr>
											<td align="center">
											<c:if test="${user_6 ne null }">
												<a href="<%=path%>/user.do?user_id=${user_6.user_id}">查看联系</a>
											</c:if>
											</td>
										</tr>
										<tr>
											<c:if test="${user_6 ne null }">
											<td align="center">
											(<fmt:formatNumber type="number" value="${(user_6.right_num - user_6.left_num - 1 ) / 2}"/>)</td>
											</c:if>
										</tr>
									</table>
								</li>

							</ul>
						</li>
						<!-- 第二层 -->
						<li>
							<table border="0" width="100%" cellpadding="0" cellspacing="0"
								height="60">
								<tr>
									<td align="center"><img src="images/app1.gif"></td>
								</tr>
								<tr>
									<td align="center">
										<c:if test="${user_3 ne null }">
											<a href="#">${user_3.user_id}</a>
										</c:if>
										<c:if test="${user_3 eq null }">
											<a href="add.jsp">推荐</a>
										</c:if>
									</td>
								</tr>
								<tr>
									<td align="center">
										<time:formattimestamp timestamp="${user_3.created_time }" format="yyyy-MM-dd"/>
									</td>
								</tr>
								<tr>
									<td align="center">
									<c:if test="${user_3 ne null }">
									<a href="<%=path%>/user.do?user_id=${user_3.user_id}">查看联系</a>
									</c:if>
									</td>
								</tr>
								<tr>
								<c:if test="${user_3 ne null }">
									<td align="center">
										(<fmt:formatNumber type="number" value="${(user_3.right_num-user_3.left_num - 1)/2 }"/>)
									</td>
								</c:if>
								</tr>
							</table>
							<!-- 第三层 -->
							<ul>
								<li>
									<table border="0" width="100%" cellpadding="0" cellspacing="0"
										height="60">
										<tr>
											<td align="center"><img src="images/ap3.gif" /></td>
										</tr>
										<tr>
											<td align="center"><a href="<%=path%>/add.jsp">推荐</a></td>
										</tr>
										<tr>
											<td align="center"></td>
										</tr>
										<tr>
											<td align="center"></td>
										</tr>
										<tr>
											<td align="center"></td>
										</tr>
									</table>
								</li>
								<li>
									<table border="0" width="100%" cellpadding="0" cellspacing="0"
										height="60">
										<tr>
											<td align="center"><img src="images/ap3.gif"></td>
										</tr>
										<tr>
											<td align="center"><a href="<%=path%>/add.jsp">推荐</a></td>
										</tr>
										<tr>
											<td align="center"></td>
										</tr>
										<tr>
											<td align="center"></td>
										</tr>
										<tr>
											<td align="center"></td>
										</tr>
									</table>
								</li>
								<li>
									<table border="0" width="100%" cellpadding="0" cellspacing="0"
										height="60">
										<tr>
											<td align="center"><img src="images/ap3.gif"></td>
										</tr>
										<tr>
											<td align="center"><a href="<%=path%>/add.jsp">推荐</a></td>
										</tr>
										<tr>
											<td align="center"></td>
										</tr>
										<tr>
											<td align="center"></td>
										</tr>
										<tr>
											<td align="center"></td>
										</tr>
									</table>
								</li>
							</ul>
						</li>
					</ul>
				</li>
			</ul>

		</div>
		<div style="width: 980px; margin: 0px auto;">
			<div id="chart" class="orgChart"></div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery-1.11.2.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/prettify.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script src="js/jquery.jOrgChart.js"></script>

	<script type="text/javascript">
		jQuery(document).ready(function() {
			$("#org").jOrgChart({
				chartElement : '#chart',
				dragAndDrop : false
			});
		});

		jQuery(document).ready(function() {
			$("#show-list").click(function(e) {
				e.preventDefault();

				$('#list-html').toggle('fast', function() {
					if ($(this).is(':visible')) {
						$('#show-list').text('Hide underlying list.');
						$(".topbar").fadeTo('fast', 0.9);
					} else {
						$('#show-list').text('Show underlying list.');
						$(".topbar").fadeTo('fast', 1);
					}
				});
			});

			$('#list-html').text($('#org').html());

			$("#org").bind("DOMSubtreeModified", function() {
				$('#list-html').text('');

				$('#list-html').text($('#org').html());

				prettyPrint();
			});
		});

		$(function() {
			$("#search").click(function() {
				var key = $("#key_title");
				if (key.val() == "") {
					key.focus();
					return false;
				}
				$("#search_fm").submit();
			});
			showMsg("divMsg");
		});

		function showMsg(objId) {
			var timerOut = null;
			clearTimeout(timerOut);
			timerOut = setTimeout(function() {
				$("#" + objId).css("display", "none");
			}, 2000);
		}
	</script>

</body>
</html>