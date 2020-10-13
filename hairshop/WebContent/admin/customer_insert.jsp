<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Enroll</title>
<script type="text/javascript" src="admin.js"></script>
<link rel="stylesheet" href="css/admin.css">
</head>
<body> <!-- 아이디 중복체크 패스워드/확인 이름 핸드폰번호 주소 -->
	<form name="formm">
		<h3>고객등록</h3>
		<table border="1">
			<tr>
				<td>아이디 :</td>
				<td><input type="text" name="id">
				<input type="hidden" name="reid" ></td> <!-- 중복확인을 위한 히든값 id -->
				<td><button onclick="idcheck()">중복체크</button></td>
			</tr>
			<tr>
				<td>패스워드 :</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td>패스워드확인 :</td>
				<td><input type="password" name="pwcheck"></td>
			</tr>
			<tr>
				<td>성명 :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>연락처 :</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>주소 :</td>
				<td><input type="text" name="address"></td>
			</tr>
		</table>
		<input type="submit" value="고객등록" onclick="insert_customer()">
		<input type="button" value="취소" onclick="window.close()">
	</form>
</body>
</html>