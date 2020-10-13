<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="UTF-8" />
<!--<fmt:requestEncoding value="UTF-8"/> JSP인코딩 형식  -->
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>로그인 : login.jsp</title>
</head>
<body>
	<h2>로그인</h2>
	<c:if test="${msg!=null}">
		<font color="red"> <b>${msg}</b>
		</font>
	</c:if>

	<c:if test="${id==null}">
		<form action="loginProc.jsp?mode=login" method="post">
			<table>
				<tr>
					<td>아이디 :</td>
					<td><input type="text" id="id" name="id" required="required" />
					</td>
				</tr>

				<tr>
					<td>비밀번호</td>
					<td><input type="password"  name="pass"
						required="required" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="로그인" /></td>
				</tr>
			</table>
		</form>
	</c:if>

	<c:if test="${id!=null}">
		<b>${id}</b>님 반갑습니다<br />
		<input type="button"
			onclick="javascript:location.href='loginProc.jsp?mode=logout'"
			value="로그아웃" />
	</c:if>
	<p />
	<a href="resgister.jsp">회원가입하러 가기</a>
</body>
</html>