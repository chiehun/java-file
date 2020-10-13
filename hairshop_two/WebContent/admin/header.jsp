<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin header</title>
<link rel="stylesheet" href="admin/css/admin.css">
<script type="text/javascript" src="admin/admin.js"></script>
<script src="http://code.jquery.com/jquery-1.7.min.js"></script>
</head>
<body>
	<div id="wrap">
		<header>
			<div id="logo">
				<img alt="Hairshop" src="admin/images/scissors.png"
					style="width: 150px; height: 150px; float: left; margin-left: 85px;"> 
					<br /><br /><br /><br />
					<input class="btn" type="button" value="Logout" style="float: right;"
					onClick="location.href='HairshopServlet?command=index'">
			</div>
		</header>
		<div class="clear"></div>