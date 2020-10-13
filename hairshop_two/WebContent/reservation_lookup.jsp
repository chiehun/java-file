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

</head>

<body>
	<!-- 예약하기 화면 -->
	<div data-role="page">
		<div data-role="header" data-position="fixed" data-theme="b">
			<a href="#" data-icon="back" data-rel="back" data-direction="reverse">Back</a>
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

			<c:choose>
			<c:when test="${list.size() == 0 }">
			<div>
				<br /><br /><br />
				 "${sessionScope.loginUser.name}"님의 현재 예약이 없습니다.
				 <button onclick="location.href='HairshopServlet?command=cus_res_form'">예약하기</button>
			</div>
			</c:when>
			
			<c:otherwise> 
			<div class="ui-body ui-body-a"> 
			<br />
			<h4>"${sessionScope.loginUser.name }님의 예약내역입니다."</h4>
					<div>
						<label><b>예약일 : </b> ${list.rsv_date }</label>
						<label><b>예약시간 : </b> ${list.rsv_time }</label>
						<label><b>시술종류 : </b> ${list.p_type }</label>
						<label><b>예약상태 : </b> ${list.rsv_status }</label>
					</div>
					<button onclick="location.href='HairshopServlet?command=cus_res_delete'">예약취소</button>					
			</div>
			</c:otherwise>
			</c:choose> 
		<div data-role="footer" data-position="fixed" data-theme="b">
			<h4>Reservation</h4>
		</div>
	</div>
	</div>
</body>
</html>