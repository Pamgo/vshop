/*
 * �û���¼��js������֤
 * 
 */

$(function() {

	$(".admin_login_btn").click(function() {
		var account = $("#account");
		var password = $("#password");
		if (account.val() == "") {
			account.focus();
			$(".link_pwd").html("�û�������Ϊ��!");
			return false;
		}
		if (password.val() == "") {
			password.focus();
			$(".link_pwd").html("���벻��Ϊ��!");
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
					$(".link_pwd").html("�û�������");
					return false;
				} else if (msg == 2) {
					$(".link_pwd").html("�������");
					return false;
				} else if (msg == 3) {
					// ��ȷ
					location.href = 'main.jsp';
				}
			},
			error : function(er) {
				console.log(er);
			}
		});

	});

});