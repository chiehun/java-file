<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url var= "nameSend" value= "test_result.jsp">
		<c:param name= "name" value= "free"></c:param>
	</c:url>
	<!--nameSend= test_result.JSP?name= free  -->
	<a href='<c:out value="${nameSend}"></c:out>'>URL</a>
	
	<c:url value="/images/tomcat.git"/>
	<img src= "/images/tomcat.git"/>
	<img var="img"value="/images/tomcat.git"/>
	
	<hr>
	<c:set var="url" value="http://www.google.com"/>
	<c:import url= "${url}"var=u/>
	<c:out value = "${u}"/>
	가져옵니다
	<hr>
</body>
</html>