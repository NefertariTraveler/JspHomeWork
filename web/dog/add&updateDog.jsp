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

        function checkDogName(dogName){
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/findDogByName.html",
                data: "dogName="+dogName+"&location=Boston",
                success: function(msg){
                    var dogNameErr = $("#dogNameErr");
                    if (msg == 0){
                        dogNameErr.html("用户名已注册");
                        dogNameErr.addClass("err");
                        return false;
                    }else {
                        dogNameErr.html("√");
                        dogNameErr.removeClass().addClass("ok");
                    }
                }
            });
        }

        var sbqNull= /^\s*$/g;
        function checkAll() {
            var dogName = $("#dogName").val();
            var pwd = $("#pwd").val();
            var rePwd = $("#rePwd").val();
            var species = $("#species").val();
            var color = $("#color").val();
            var health = $("#health").val();

            var dogNameErr = $("#dogNameErr");
            var pwdErr = $("#pwdErr");
            var rePwdErr = $("#rePwdErr");
            var speciesErr = $("#speciesErr");
            var colorErr = $("#colorErr");
            var healthErr = $("#healthErr");

            if (sbqNull.test(dogName)){
                dogNameErr.html("狗狗名不能为空");
                dogNameErr.addClass("err");
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

            if (species<1){
                speciesErr.html("请选择品牌");
                speciesErr.addClass("err");
                return false;
            }else {
                speciesErr.html("√");
                speciesErr.removeClass().addClass("ok");
            }

            if (color<1){
                colorErr.html("请选择颜色");
                colorErr.addClass("err");
                return false;
            }else {
                colorErr.html("√");
                colorErr.removeClass().addClass("ok");
            }

            if (sbqNull.test(health)){
                healthErr.html("请输入健康值");
                healthErr.addClass("err");
                return false;
            }else {
                healthErr.html("√");
                healthErr.removeClass().addClass("ok");
            }

            return checkUserName();
        }
    </script>
</head>
<body>
    <%--${msg=='2' ? 'updatePhone.html' : 'addPhone.html'}--%>
    <form action="${pageContext.request.contextPath}/${msg=='2' ? 'updateDog.html' : 'addDog.html'}" method="post" onsubmit="return checkAll();">
        <input type="hidden" name="id" value="${dog.id}">
        狗狗名：<input type="text" name="dogName" id="dogName" value="${dog.dogName}" onchange="checkDogName(this.value);"/>
                <span id="dogNameErr"></span><br />
        密码：<input type="password" name="pwd" id="pwd" value="${dog.pwd}" />
             <span id="pwdErr"></span><br />
        确认密码：<input type="password" name="rePwd" id="rePwd" />
                <span id="rePwdErr"></span><br />
        品种：<select name="species" id="species">
                <option value="-1">===请选择===</option>
                <option value="1">比熊</option>
                <option value="2">柯基犬</option>
                <option value="3">迷你雪纳瑞</option>
                <option value="4">边境牧羊犬</option>
                <option value="5">哈士奇</option>
                <option value="6">柴犬</option>
                <option value="7">金毛寻回犬</option>
                <option value="8">阿拉斯加犬</option>
                <option value="9">苏格兰牧羊犬</option>
                </select>
                 <span id="speciesErr"></span><br />
        颜色：<select name="color" id="color">
                <option value="-1">===请选择===</option>
                <option value="1">黄色</option>
                <option value="2">黑色</option>
                <option value="3">白色</option>
                <option value="4">棕色</option>
                <option value="5">灰色</option>
                <option value="6">花色</option>
                </select>
                <span id="colorErr"></span><br />
        健康值：<input name="health" id="health" value="${dog.health}" />
                <span id="healthErr"></span><br />
                 <input type="submit" value="提交"/>
    </form>
</body>
</html>
