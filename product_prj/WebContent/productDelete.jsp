<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	int code= Integer.parseInt(request.getParameter("code"));
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>productDelete.jsp</title>
</head>
<body>
	<h3>상품 삭제</h3>
	<form action="productDeleteProc.jsp" method="get">
	<input type="text" name="code" value="<%=code%>">
		<input type="submit" value="삭제"/>
		<input type="button" value="리스트" onclick="javascript:location.href='productList.jsp'"/>
	</form>
</body>
</html>