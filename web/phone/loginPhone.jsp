<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>登录</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css"/>
		<script>
			var sbqNull= /^\s*$/g;
			function checkLogin() {
				var userName = document.getElementById("userName").value;
				var pwd = document.getElementById("pwd").value;
				var userNameErr = document.getElementById("userNameErr");
				if (sbqNull.test(userName)){
					userNameErr.innerHTML = "用户名不能为空";
					userNameErr.className = "err";
					return false;
				}else {
					userNameErr.innerHTML = "√";
					userNameErr.className = "ok";
				}

				var pwdErr = document.getElementById("pwdErr");
				if (sbqNull.test(pwd)){
					pwdErr.innerHTML = "密码不能为空";
					pwdErr.className = "err";
					return false;
				}else {
					pwdErr.innerHTML = "√";
					pwdErr.className = "ok";
				}

				return true;
			}
		</script>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/loginPhone.html" onsubmit="return checkLogin();" method="post">
			用户名：<input type="text" name="userName" id="userName"/>
			<span id="userNameErr"></span><br />
			密码：<input type="password" name="pwd" id="pwd"/>
			<span id="pwdErr"></span><br />
			<input type="submit" value="登录"/>
		</form>
	</body>
</html>
