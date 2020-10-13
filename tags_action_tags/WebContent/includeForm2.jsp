<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>includeForm2.jsp</title>
</head>
<body>
	<h2>include 액션 태그에서 포함되는 페이젱 값 전달하기</h2>
	<form method= "post" action = "includeMain2.jsp">
		사이트 명 : <input type=url name= "siteName" required = "required" >
		<input type="submit" value="보내기"/>
	
	</form>

</body>
</html>