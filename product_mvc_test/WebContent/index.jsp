<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>게시판  리스트로 보내는 주는 : 처음 실행만 하는 역할</title>
</head>
<body>
<%
	response.sendRedirect("http://localhost:9000/product_mvc_test/productServlet?command=product_list");
%>
</body>
</html>