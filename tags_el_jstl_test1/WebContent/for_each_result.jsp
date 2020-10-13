<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    	String[] stringArray= {"aa", "bb", "cc", "dd"};
    	request.setAttribute("strArr", stringArray);%>
<!DOCTYPE >
<html>
<head>
<meta charset=UTF-8>
<title>반복</title>
</head>
<body>

	<h3> 반복</h3>
	<h4></h4>
	<c:forEach var="one" begin="1" end="10" step="3">
		<c:out value= "${one}"/>
	</c:forEach>
</body>
</html>