<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 가입 </title>
</head>
<body>
<form action="join.do" method="post">
<p>
	아이디:<br/><input type="text" name="id" value="${param.id}">
	<c:if test="${errors.id}">ID를 입력하세요</c:if>
	<c:if test="${errors.duplicteld}">이미 사용중인 아이디 입니다.</c:if>
</p>
<p>
	이름 :<br/><input type="text" name="name" value="${param.name}">
	<c:if test="${errors.name}">  이름을 입력하세요</c:if>
</p>
<p>
	암호 :<br/><input type="text" name="password" value="${param.name}">
	<c:if test="${errors.password}">  암호을 입력하세요</c:if>
</p>
<p>	
	확인 :<br/><input type="password" name="confirmPassword">
	<c:if test="${errors.confirmPassword}">암호를 다시한번 입력해 주세요</c:if>
	<c:if test="${errors.notMatch}">암호와 확인이 일치하지 않습니다.</c:if>
</p>
<input type="submit" value="가입" >
</form>
</body>
</html>