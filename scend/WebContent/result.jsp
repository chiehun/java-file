<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>덧셈 프로그램</title>
</head>
<body>
<% 
	int n1 = Integer.parseInt(request.getParameter("NUM1"));
	int n2 = Integer.parseInt(request.getParameter("NUM2"));
	int s = (int)request.getAttribute("result");
			%>
		<%= n1 %> + <%= n2 %> = <%= s %>
</body>
</html>