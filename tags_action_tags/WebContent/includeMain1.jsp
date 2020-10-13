<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8>
<title>includeMain1.jsp</title>
</head>
<body>
<h1>포함하는 페이지 includeMain.jsp 입니다</h1>

<% request.setCharacterEncoding("UTF-8"); %>
<hr> <!--  구분선 -->

<jsp:include page="includeSub1.jsp"/>



</body>
</html>