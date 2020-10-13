<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri= "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE >
<html>
<head>
<meta  charset=UTF-8>
<title>fn_function.jsp</title>
</head>
<body>
	<c:set var= "greeting" value= "'C'est va bien"></c:set>
	Original String : ${greeting}
	
	<br/> All Capital Letter : ${fn:toUpperCase(greeting)}
	<br/> All lower case : ${fn:toLowerCase(greeting)}
	<br/> location of 'va' : ${fn:indexOf(greeting, "va"} 
	<br/> length of String : ${fn:length(greeting)}
</body>
</html>