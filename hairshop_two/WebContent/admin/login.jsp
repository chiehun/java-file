<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin login</title>

<script type="text/javascript" src="admin/admin.js"></script>
<link rel="stylesheet" href="admin/css/admin.css">

</head>
<body>
	<div id="wrap">
		<div class="clear"></div>
		<div id="loginform">
			<p align="left">
				<b id="b">Admin mode</b>
			</p>
			<form name="frm" method="post" action="HairshopServlet?command=admin_login">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="workerid" size="10"
							value="admin1"></td>
					</tr>
					<tr>
						<td>비밀 번호</td>
						<td><input type="password" name="workerpw" size="10"
							value="1234"></td>
					</tr>
					<tr align="right">
						<td colspan="2"><input type="submit" value="Login" onclick="return worker_check()">
						<br /><br />
						<h4 style="color: red;">${message }</h4></td>
					</tr>
						
						
				</table>
			</form>
		</div>
	</div>
</body>
</html>