<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin header</title>
<link rel="stylesheet" href="css/admin.css">
<script type="text/javascript" src="admin.js"></script>
<script src="jquery-1.6.2.js" type="text/javascript"></script>
</head>
<body>
	<div id="wrap">
		<header>
			<div id="logo">
				<img alt="Hairshop" src="images/scissors.png"
					style="width: 150px; height: 150px; float: left; margin-left: 85px;"> 
					<br /><br /><br /><br />
					<input class="btn" type="button" value="Logout" style="float: right;"
					onClick="location.href='login.jsp'">
			</div>
		</header>
		<div class="clear"></div>