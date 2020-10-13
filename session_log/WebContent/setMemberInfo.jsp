<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    // setMemberInfo/js
   //jsp는 session이 내장객체로 존재....
   //서블릿에서는 getsessoin으로 따로 얻어줘야 한다.
   //Dto라고 
   session.setAttribute("MEMBERRID", "freeflux");
    session.setAttribute("NAME", "free");
    %>
<!DOCTYPE >
<html>
<head>
<meta charset=UTF-8>
<title>setMemberInfo.jsp</title>
</head>
<body>
세션에 정보를 저장하였습니다.
</body>
</html>