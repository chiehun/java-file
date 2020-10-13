<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE >
<html>
<head>
<meta charset=UTF-8>
<title>choose_result.jsp</title>
</head>
<body>
	<c:set var="gender" value="<%=2%>"></c:set>
	<!-- if() else if()else if(){}else() -->
	<c:choose>
		<c:when test="${gender==1}">
남자입니다
</c:when>

		<c:when test="${gender==2}">
여자입니다
</c:when>

		<c:otherwise>
그 외? 흑??------
</c:otherwise>
	</c:choose>
</body>
</html>