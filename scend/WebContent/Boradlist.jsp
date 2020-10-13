<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8">
<title>Board_LIST</title>
</head>
<body>

<% File f= new File("c:/bbs");
 String[] filenames=f.list();%>
 
<table border="1">
<tr><th>파일명</th></tr>

<%
for(String f_name : filenames){		
	out.println("<tr><td>");
	out.println("<a href=BoardContent.jsp?f="+f_name+">");
	out.println(f_name);
	out.println("</a>");
	out.println("</td></td>");
 }%>

</table>
<button onclick="location.href='BoardInput.html'">글쓰기</button>
</body>
</html>