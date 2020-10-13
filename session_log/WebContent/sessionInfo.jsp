<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "true" %>
<%@ page import = "java.util.Date"%>
<%@ page import = "java.text.SimpleDateFormat"%>
<%
	Date time = new Date(); //settime 메서드로 날짜로 시간을 먼저 저장 시켜나야 한다. 
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//날짜와 시간을 저장해 주는 
%>
<!DOCTYPE >
<html>
<head>
<meta charset=UTF-8>
<title>세션 정보</title>
</head>
<body>
세션 ID : <%= session.getId() %>//세션에서 자동적으로 생성해 주는 id<br/>

<% time.setTime(session.getCreationTime()); %>//getCreationtime 메서드를 활용해서 시간을 재야한다.
세션생성시간 : <%= formatter.format(time) %><br/>

<% time.setTime(session.getLastAccessedTime()); %>
최근 접근 시간 : <%= formatter.format(time) %>
</body>
</html>