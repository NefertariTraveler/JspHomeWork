<%--
  Created by IntelliJ IDEA.
  User: 刘寿伟
  Date: 2022/2/4
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        var sbqNull= /^\s*$/g;
        function checkLogin() {
            var dogName = $("#dogName").val();
            var pwd = $("#pwd").val();
            var dogNameErr = $("#dogNameErr");
            if (sbqNull.test(dogName)){
                dogNameErr.html("用户名不能为空");
                dogNameErr.addClass("err");
                return false;
            }else {
                dogNameErr.html("√");
                dogNameErr.removeClass().addClass("ok");
            }

            var pwdErr = $("#pwdErr");
            if (sbqNull.test(pwd)){
                pwdErr.html("密码不能为空");
                pwdErr.addClass("err");
                return false;
            }else {
                pwdErr.html("√");
                pwdErr.removeClass().addClass("ok");
            }

            return true;
        }
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath}/loginDog.html" onsubmit="return checkLogin();" method="post">
    用户名：<input type="text" name="dogName" id="dogName"/>
    <span id="dogNameErr"></span><br />
    密码：<input type="password" name="pwd" id="pwd"/>
    <span id="pwdErr"></span><br />
    <input type="submit" value="登录"/>
</form>
</body>
</html>
