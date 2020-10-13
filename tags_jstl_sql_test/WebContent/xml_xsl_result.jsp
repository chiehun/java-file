<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>연락처</h1>
<c:import var="xml" url="namecard.xml" charEncoding="UTF-8"/>
<c:import var="xsl" url="namecard.xsl" charEncoding="UTF-8"/>

<x:transform xml="${xml}" xslt="${xsl}"/>
</body>
</html>