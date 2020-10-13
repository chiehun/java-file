<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name = request.getParameter("name");
	String color = request.getParameter("bloodType");

%>

	<b> <%= "name" %> </b>님이 
	<b> <%= "color" %></b>좋아하는 색은 빨간색이고
	<p> ㅁㄴㅇㄻㄴㅇㄻㄴㅇㄹㄴㅁㅇㄹ
	<p> <img src = "red.jpg">
	
</body>
</body>
</html>