<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    	String[] stringArray= {"aa", "bb", "cc", "dd"};
    	request.setAttribute("strArr", stringArray);%>
<!DOCTYPE >
<html>
<head>
<meta  charset=UTF-8>
<title>for_each.jsp</title>
</head>
<body>
<table border="1">
<!-- for( : ){  } -->
	<c:forEach var="str" items="${strArr}">
	<tr>
	<td>${str}</td>
	</tr>	
	</c:forEach>
	

<!-- var 에서는 그 값을 대입 받을  변수명 item 다중값( 배열 변수) -->

</table>

</body>
</html>