<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String selectedcolor = request.getParameter("color");

%>

	<b> <%= "name" %> </b>님이 
	<b> <%= "color" %></b>좋아하는 색은 파란색이고
	<p> 자기 탐구와 내적 성장을 상징하는 색입니다
	<p><img src ="blue.jpg">
	<!-- 별도의 파리미터와 값을 전달하고 싶은경우 -->
	<jsp:forward page = "<%= selectedcolor + \".jsp\" %>">
	<jsp:param name = "selectedColor" value = "<%=selectedcolor %>"/>
	<jsp:param name = "name" value = "<%=name %>"/>
	</jsp:param>
	
</body>
</html>