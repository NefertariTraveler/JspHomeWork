<%--
  Created by IntelliJ IDEA.
  User: 刘寿伟
  Date: 2022/1/28
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        /*$(function () {
            alert("进来了吗");
        })*/

        function checkUserName(userName){
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/findComputerByName.html",
                data: "userName="+userName+"&location=Boston",
                success: function(msg){
                    var userNameErr = $("#userNameErr");
                    if (msg == 0){
                        userNameErr.html("用户名已注册");
                        userNameErr.addClass("err");
                        return false;
                    }else {
                        userNameErr.html("√");
                        userNameErr.removeClass().addClass("ok");
                    }
                }
            });
        }

        var sbqNull= /^\s*$/g;
        function checkAll() {
            var userName = $("#userName").val();
            var pwd = $("#pwd").val();
            var rePwd = $("#rePwd").val();
            var brand = $("#brand").val();
            var size = $("#size").val();
            var color = $("#color").val();
            var sales = $("#sales").val();

            var userNameErr = $("#userNameErr");
            var pwdErr = $("#pwdErr");
            var rePwdErr = $("#rePwdErr");
            var brandErr = $("#brandErr");
            var sizeErr = $("#sizeErr");
            var colorErr = $("#colorErr");
            var salesErr = $("#salesErr");

            if (sbqNull.test(userName)){
                userNameErr.html("用户名不能为空");
                userNameErr.addClass("err");
                return false;
            }

            if (sbqNull.test(pwd)){
                pwdErr.html("密码不能为空");
                pwdErr.addClass("err");
                return false;
            }else if (pwd.length<6){
                pwdErr.html("密码不能少于6位");
                pwdErr.addClass("err");
                return false;
            }else {
                pwdErr.html("√");
                pwdErr.removeClass().addClass("ok");
            }

            if (sbqNull.test(rePwd)){
                rePwdErr.html("确认密码不能为空");
                rePwdErr.addClass("err");
                return false;
            }else if (rePwd!=pwd){
                rePwdErr.html("两次密码不一致");
                rePwdErr.addClass("err");
                return false;
            }else {
                rePwdErr.html("√");
                rePwdErr.removeClass().addClass("ok");
            }

            if (brand<1){
                brandErr.html("请选择品牌");
                brandErr.addClass("err");
                return false;
            }else {
                brandErr.html("√");
                brandErr.removeClass().addClass("ok");
            }

            if (sbqNull.test(size)){
                sizeErr.html("尺寸不能为空");
                sizeErr.addClass("err");
                return false;
            }else {
                sizeErr.html("√");
                sizeErr.removeClass().addClass("ok");
            }

            if (color<1){
                colorErr.html("请选择颜色");
                colorErr.addClass("err");
                return false;
            }else {
                colorErr.html("√");
                colorErr.removeClass().addClass("ok");
            }

            if (sbqNull.test(sales)){
                salesErr.html("销量不能为空");
                salesErr.addClass("err");
                return false;
            }else {
                salesErr.html("√");
                salesErr.removeClass().addClass("ok");
            }

            return checkUserName();
        }
    </script>
</head>
<body>
    <%--${msg=='2' ? 'updatePhone.html' : 'addPhone.html'}--%>
    <form action="${pageContext.request.contextPath}/${msg=='2' ? 'updateComputer.html' : 'addComputer.html'}" method="post" onsubmit="return checkAll();">
        <input type="hidden" name="id" value="${computer.id}">
        用户名：<input type="text" name="userName" id="userName" value="${computer.userName}" onchange="checkUserName(this.value);"/>
                <span id="userNameErr"></span><br />
        密码：<input type="password" name="pwd" id="pwd" value="${computer.pwd}" />
             <span id="pwdErr"></span><br />
        确认密码：<input type="password" name="rePwd" id="rePwd" />
                <span id="rePwdErr"></span><br />
        品牌：<select name="brand" id="brand">
                <option value="-1">===请选择===</option>
                <option value="1">三星</option>
                <option value="2">苹果</option>
                <option value="3">华为</option>
                <option value="4">联想</option>
                <option value="5">小米</option>
                </select>
                 <span id="brandErr"></span><br />
        尺寸：<input name="size" id="size" value="${computer.size}" />
             <span id="sizeErr"></span><br />
        颜色：<select name="color" id="color">
                <option value="-1">===请选择===</option>
                <option value="1">雪盈白</option>
                <option value="2">星空紫</option>
                <option value="3">幻色粉</option>
                <option value="4">梦镜红</option>
                <option value="5">陶瓷黑</option>
                <option value="6">星云渐变</option>
                </select>
                <span id="colorErr"></span><br />
        销量：<input name="sales" id="sales" value="${computer.sales}" />
            <span id="salesErr"></span><br />
             <input type="submit" value="提交"/>
    </form>
</body>
</html>
