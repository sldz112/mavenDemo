<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>    
    <%@ include file="type.jsp" %>
    <jsp:useBean id="sc" class="com.bean.Score" scope="request"></jsp:useBean> 
    <jsp:setProperty property="*" name="sc"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>处理</title>
<%
String top=request.getParameter("op");

%>
<jsp:forward page="scoreServlet">
<jsp:param value="<%=top%>" name="op"/>
</jsp:forward>
</head>
<body>

</body>
</html>