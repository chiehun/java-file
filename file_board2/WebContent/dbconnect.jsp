<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*" %>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8">
<title> 데이터베이스 연결</title>
</head>
<body>
<%
Class.forName("com.mysql.jdbc.Driver");
String url ="jdbc:mysql://localhost:3306/bbsdb";
String id = "root";
String pw = "1234";

Connection conn = DriverManager.getConnection(url, id, pw);
if(conn != null){
	out.println("bbsdb 연결 성공");
	conn.close();
	out.println("bbsdb 접속 끊기 성공!");
	}else{
		out.println("bbsdb 연결 할 수 없습니다");
	}
%>
</body>
</html>