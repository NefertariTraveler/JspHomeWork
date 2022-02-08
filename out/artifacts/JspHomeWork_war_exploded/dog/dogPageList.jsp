<%--
  Created by IntelliJ IDEA.
  User: 刘寿伟
  Date: 2022/1/28
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <table width="80%" align="center">
        <tr>
            <td>
                <a href="${pageContext.request.contextPath}/dog/add&updateDog.jsp">添加</a>
            </td>
        </tr>
    </table>
</form>
<table border="1" width="80%" cellspacing="0" cellpadding="0" align="center">
    <tr>
        <td>序号</td>
        <td>狗狗名</td>
        <td>密码</td>
        <td>品种</td>
        <td>颜色</td>
        <td>健康值</td>
        <td>日期</td>
        <td>操作</td>
    </tr>
    <c:forEach var="li" items="${msg}">
        <tr>
            <td>${li.id}</td>
            <td>${li.dogName}</td>
            <td>${li.pwd}</td>
            <td>${li.species}</td>
            <td>${li.color}</td>
            <td>${li.health}</td>
            <td>${li.date}</td>
            <td>
                <a href="${pageContext.request.contextPath}/findDogById.html?id=${li.id}">修改</a>
                <a href="${pageContext.request.contextPath}/deleteDog.html?id=${li.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<table width="80%" align="center">
    <tr align="center">
        <td>
            第&nbsp;&nbsp;${info.pageNo}&nbsp;&nbsp;页<br>
            共&nbsp;&nbsp;${info.totalPageCount}&nbsp;&nbsp;页<br>
            共&nbsp;&nbsp;${info.totalCount}&nbsp;&nbsp;条数据<br>

            <c:if test="${info.pageNo>1}">
                <a href="${pageContext.request.contextPath}/dogPage.html?pageNo=1">首页</a>
                <a href="${pageContext.request.contextPath}/dogPage.html?pageNo=${info.pageNo-1}">上一页</a>
            </c:if>
            <c:if test="${info.pageNo<info.totalPageCount}">
                <a href="${pageContext.request.contextPath}/dogPage.html?pageNo=${info.pageNo+1}">下一页</a>
                <a href="${pageContext.request.contextPath}/dogPage.html?pageNo=${info.totalPageCount}">末页</a>
            </c:if>
        </td>
    </tr>
</table>
</body>
</html>
