<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:requestEncoding value="UTF-8" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 가입</h2>
	<form action="registerProc.jsp" method="post">
		<table border="1" width="300">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" required="required" /></td>
			</tr>

			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pass" required="required" /></td>
			</tr>

			<tr>
				<td>이름</td>
				<td><input type="text" name="name" required="required" /></td>
			</tr>

			<tr>
				<td>메일</td>
				<td><input type="email" name="email" required="required" /></td>
			</tr>

			<tr>
				<td>홈페이지</td>
				<td><input type="url" name="hp" required="required" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="가입" /></td>
			</tr>
		</table>
	</form>
	<p/>
	<a href ="login.jsp"> 로그인 하러 가기 </a>
</body>
</html>