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

</head>

<body>
	<!-- 회원가입 화면 -->
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
			<div class="ui-body ui-body-a">
			<h3>회원가입</h3>
				<form name="formm" method="post">
					
					<label><b>아이디 :</b></label>
					<input type="text" name="id">
					<fieldset data-role="controlgroup" data-type="horizontal" style="text-align:right">
					<button>중복체크</button>
					</fieldset>
					
					<label><b>패스워드 :</b></label>
					<input type="password" name="pw">
					<label><b>패스워드 확인 :</b></label>
					<input type="password" name="pwcheck">
					
					<label><b>성명 :</b></label>
					<input type="text" name="name">
					<label><b>연락처 :</b></label>
					<input type="text" name="phone" placeholder=" ' - ' 포함하여 입력해주십시오.">
					<label><b>주소 :</b></label>
					<input type="text" name="address">
					
					<br /><br />
					<input type="button" value="가입"
					onclick = "insert_customer()">
				</form>
			</div>
		<div data-role="footer" data-position="fixed" data-theme="b">
			<h4>Join</h4>
		</div>
	</div>
	</div>
</body>
</html>