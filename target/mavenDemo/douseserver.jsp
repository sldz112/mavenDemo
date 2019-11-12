<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="type.jsp" %>
    <!-- 设置scope=request 是为了在userServlet.java界面获取到us对象 -->
    <jsp:useBean id="us" class="com.bean.login" scope="request"></jsp:useBean>
    <jsp:setProperty property="*" name="us"/>
<!DOCTYPE html>
<html>
<head>
<%
String top=request.getParameter("op");
%>
<!--获取前台JSP界面传过来的OP  -->
<jsp:forward page="userServlet">
<jsp:param value="<%=top%>" name="op"/>
</jsp:forward>
<meta charset="utf-8">
<title>注册用户业务处理层</title>
</head>
<body>

</body>
</html>