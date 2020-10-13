<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>el_test.jsp</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
<!--  EL_TEST.JSP?NAME=aaa -->
당신의 이름은 ${param.name}입니다.
</body>
</html>