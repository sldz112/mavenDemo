<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>展示学生列表</title>
</head>
<body>
<table width="400" border="1" align="center" bgcolor="#FFFFCC" cellspacing="0" cellpadding="3">
<tr>
<td>学生编号</td>
<td>学生姓名</td>
<td>学生班级</td>
<td>学生图片</td>
</tr>
<c:forEach items="${lst}" var="pb">
<tr>
<td>${pb.stuid}</td>
<td>${pb.sname}</td>
<td>${pb.sclazz}</td>
<td>
<a href="picture/${pb.spicture}">
<img width="110" height="110" alt="" src="picture/${pb.spicture}">
</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>