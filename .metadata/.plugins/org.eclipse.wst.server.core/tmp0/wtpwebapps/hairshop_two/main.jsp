<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hairshop Customer Page</title>

<!-- 제이쿼리 모바일, 제이쿼리 라이브러리 파일 -->
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.7.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

<!-- 스크립트 추가 내용 -->
<script type="text/javascript" src="customer.js"></script>

<style type="text/css">
img {
	padding: 10px;
	margin: 10px 50px;
	width: 180px;
	height: 180px;
}

.gap {
	padding-top: 15px;
	padding-bottom: 30px;
}
</style>

</head>

<body>
	<!-- 시작 화면 -->
	<div data-role="page">
		<div data-role="header" data-position="fixed" data-theme="b">
			<h1>HairShop</h1>
			<a href="HairshopServlet?command=cus_index" data-icon="home" data-iconpos="notext"
				class="ui-btn-right">Home</a>
				<div data-role="navbar">
				<ul>
				<c:choose>
				<c:when test="${empty sessionScope.loginUser }">
					<li><a href="HairshopServlet?command=cus_login_form">로그인</a></li>
					<li><a href="HairshopServlet?command=cus_join_form">회원가입</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="HairshopServlet?command=cus_logout">로그아웃</a>
				</c:otherwise>
				</c:choose>
				</ul>
			</div>
		</div>
		<div data-role="content">
			<img src="admin/images/scissors.png">
			<ul data-role="listview" data-inset="true">
				<li><a href="HairshopServlet?command=cus_res_form">예약하기</a></li>
				<li><a href="HairshopServlet?command=cus_res_check">예약조회</a></li>
			</ul>
		</div>
		<div data-role="footer" data-position="fixed" data-theme="b">
			<h4>Main</h4>
			<a onclick="gogo()" data-ajax="false" class="ui-btn-right">Admin_mode</a>
		</div>
	</div>
</body>
</html>