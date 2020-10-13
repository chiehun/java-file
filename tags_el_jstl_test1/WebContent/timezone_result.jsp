<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  uri="http://java.sun.com/jstl/core" prefix="c"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE >
<html>
<head>
<meta  charset=UTF-8">
<title>timezone_result.jsp</title>
</head>
<body>
<pre>
	ko_KR / en_US
	<fmt:setLocale value= "ko_KR"/>
	<jsp:useBean id="now" class="java.util.Date"/>
	
	<h4>
	<fmt:formatDate value="${now}" dateStyle= "full"/>
	<fmt:formatDate value="${now}" type="time"/>
	</h4>
	
	both : <fmt:formatDate value="${now}" type="both"/>
	
	default : <fmt:formatDate value="${now}" type="both" dateStyle= "default" timeStyle= "default"/>
	
	short : <fmt:formatDate value="${now}" type="both" dateStyle= "short" timeStyle= "short"/>
	
	medium : <fmt:formatDate value="${now}" type="both" dateStyle= "medium" timeStyle= "medium"/>
	
	long : <fmt:formatDate value="${now}" type="both" dateStyle= "long" timeStyle= "long"/>
	
	full : <fmt:formatDate value="${now}" type="both" dateStyle= "full" timeStyle= "full"/>
	
	pattern= "yyyy년MM월dd일 HH시 mm분ss초"
	<fmt:formatDate value="${now}" type="both" pattern= "yyyy년MM월dd일 HH시mm분ss초"/>
	
	<fmt:timeZone value= "GMT">
	Swiss GMT :
	<fmt:formatDate value="${now}" type="both" dateStyle= "full" timeStyle= "full"/>
	</fmt:timeZone>
	
	<fmt:timeZone value="GMT-8">
	NewYork GMT-8;
	<fmt:formatDate value="${now}" type="both" dateStyle= "full" timeStyle= "full"/>
	</fmt:timeZone>
	</pre>
</body>
</html>