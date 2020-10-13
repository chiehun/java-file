<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forwardFrom2.jsp</title>
</head>
<body>
	<h1>포워딩하는 페이지 : forwardFrom2.jsp</h1>

	<%
	 request.setCharacterEncoding("UTF-8");
	String bloodType = request.getParameter("bloodType") + ".jsp";
	//A형 선택시 String bloodType = "a.jsp"
	%>
	
	<jsp:forward page= "<%= bloodType %>" />
	<!-- forward 액션 태그 때문에 이 파일의 내용은 화면 출력 안된다 -->
	<!--ex) bloodType = a.jsp-->
</body>
</html>