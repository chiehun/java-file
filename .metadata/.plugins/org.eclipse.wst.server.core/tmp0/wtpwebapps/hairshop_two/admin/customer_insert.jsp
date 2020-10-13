<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Enroll</title>
<script type="text/javascript" src="admin/admin.js"></script>
<link rel="stylesheet" href="admin/css/admin.css">
</head>
<body> <!-- 아이디 중복체크 패스워드/확인 이름 핸드폰번호 주소 -->
	<h3 style="margin-left: 100px;">고객등록</h3>
	<form name="formm" style="text-align: center;">
		<table id ="detailLeft" style="margin-left : 30px;">
			<tr>
				<th>아이디 :</th>
				<td><input type="text" name="id">
				<input type="hidden" name="reid" ></td> <!-- 중복확인을 위한 히든값 id -->
				<td><button id="butt" onclick="idcheck()">중복체크</button></td>
			</tr>
			<tr>
				<th>패스워드 :</th>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<th>패스워드확인 :</th>
				<td><input type="password" name="pwcheck"></td>
			</tr>
			<tr>
				<th>성명 :</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>연락처 :</th>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<th>주소 :</th>
				<td><input type="text" name="address"></td>
			</tr>
		</table>
		<br />
		<input id="butt" type="button" value="고객등록" onclick="insert_customer()">
		<input id="butt" type="button" value="취소" onclick="window.close()">
	</form>
</body>
</html>