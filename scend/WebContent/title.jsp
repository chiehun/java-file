<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8">
<title>게시판 글쓰기</title>
</head>
<body>
	<% request.setCharacterEncoding("UTF-8"); %>
	<%=request.getParameter("name")%><br />

	<%=request.getParameter("title")%><br />
	--------------------------------------
	<br />
	<%=request.getParameter("context")%><br />
	--------------------------------------
	<br /> 저장 되었습니다
</body>
</html>