<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forwardTo1.jsp</title>
</head>
<body>
<h2>포워딩되는 페이지 : forwardTo1.jsp</h2>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
%> <b>

<%=id%>
</b>님의 <p> 패스워드는 <b><%=password %></b>입니다

</body>
</html>