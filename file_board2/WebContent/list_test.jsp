<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.* , com.hun.BBSClass " %>
<%
	ArrayList<BBSClass> list =(ArrayList<BBSClass>)request.getAttribute("List");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title> 목록 화면</title>
</head>
<body>
<%
for(BBSClass bbs : list){
	out.print(bbs.getTitle()+"--");
	out.print(bbs.getWriter()+"--");
	out.print(bbs.getContent()+"--");
	out.print(bbs.getSeqno()+"--");	
}

%>
</body>
</html>