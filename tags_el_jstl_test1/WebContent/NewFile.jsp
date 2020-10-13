<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="com.hun.test.InFoModel" %>
    <%
    InFoModel info = new InFoModel();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="info" value= "<%= info %>" ></c:set>
<c:set target= "${info}" property= "name" value="테스트"></c:set>
<c:set target= "${info}" property= "age" value="24"></c:set>

회원 이름 : ${info.name}<br/>
나이 : ${info.age} <br/>
</body>
</html>