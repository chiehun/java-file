<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8>
<title>viewMemberInfo.jsp : 세션 정보 조회</title>
</head>
<body>
	MEMBERRID = <%= session.getAttribute("MEMBERRID") %><br/>
	NAME = <%= session.getAttribute("NAME") %>
</body>
</html>