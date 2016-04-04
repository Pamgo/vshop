/*
 * 用户登录的js基本验证
 * 
 */

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
				account:account.val(),
				password:password.val()
			},
			datatype:"json",
			success : function(msg) {
				if (msg == 1) {
					$(".link_pwd").html("用户名错误");
					return false;
				} else if (msg == 2) {
					$(".link_pwd").html("密码错误");
					return false;
				} else if (msg == 3) {
					// 正确
					location.href = 'main.jsp';
				}
			},
			error : function(er) {
				console.log(er);
			}
		});

	});

});