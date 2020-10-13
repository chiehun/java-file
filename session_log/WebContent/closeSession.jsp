<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	session.invalidate(); //세션을 완전 종료 하기 위해서는 마지막에 invalidate()메서드를 실행 시켜야한다.
%>
<!DOCTYPE >
<html>
<head>
<meta charset=UTF-8>
<title>세션 종료 : closeSession.jsp</title>
</head>
<body>
세션을 종료하였습니다
</body>
</html>