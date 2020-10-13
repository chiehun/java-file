<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>a.jsp</title>
</head>
<body>
<h1>포워딩 되는 페이지(a.jsp)</h1>

<%
	String name = request.getParameter("name");
	String bloodType = request.getParameter("bloodType");

%>

	<b> <%= name %> </b>님의 혈액형은
	<b> <%= bloodType %></b>형이고
	<p> 성실하고 신중하고 완벽주의자 입니다
</body>
</html>