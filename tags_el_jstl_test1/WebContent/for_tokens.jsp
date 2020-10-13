<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE >
<html>
<head>
<meta charset=UTF-8>
<title>for_tokens.jsp</title>
</head>
<body>
<h3>반복</h3>
<h4>&lt; c:forTokens></h4>
<%--&lt  =>  <   --%>
<%-- &lt; c:forTokens> => c:forTokens> --%>
<%-- c:forTokens> 문자열 쪼개어 출력--%>

<c:forTokens var="one" items="서울|인천,대전,대구,부산,광주,평양 " delims="," varStatus= "sts">

	<c:out value= "${sts.count}.${one}"/>&middot;	
</c:forTokens>&nbsp;


<c:forTokens var="one" items="서울|인천,대전,대구,부산,광주,평양 " delims="|" varStatus= "sts">

	<c:out value= "${sts.count}.${one}"/>&#149;	
</c:forTokens>
</body>
</html>