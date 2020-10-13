<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta  charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String appPath = application.getContextPath();
	String filePath = application.getRealPath("title.jsp");
	%>

	웹 애플리케이션 URL 경로명 : <%= appPath%> <br/>
	
	title파일의 경로명 : <%= filePath %>
</body>
</html>