<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8">
<title>log.jsp JSP html</title>
</head>
<body>
n1 :
<%= request.getParameter("num1") %>
+
n2 :
<%= request.getParameter("num2") %>

<% int n1 = Integer.parseInt(request.getParameter("num1"));
 int n2 = Integer.parseInt(request.getParameter("num2"));
 %>
=
<%= n1+n2 %>
</body>
</html>