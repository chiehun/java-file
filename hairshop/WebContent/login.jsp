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
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

<!-- 스크립트 추가 내용 -->
<script type="text/javascript">
function id_check() {
	if (document.formm.id.value == "") {
		alert("아이디를 입력하세요.");
		return false;
	} else if (document.formm.pw.value == "") {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
}
</script>
</head>

<body>
	<!-- 로그인 화면 -->
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
			<div class="ui-body ui-body-a gap">
			<h2>로그인페이지</h2>
				<form name="formm" action="HairshopServlet?command=cus_login" method="post">
					<label><b>ID :</b></label>
					<input type="text" name="id">
				
					<label><b>PW :</b></label>
					<input type="password" name="pw">
					<br /><br />
					<input type="submit" value="로그인"
					onclick="return id_check()">
				</form>
			</div>
		<div data-role="footer" data-position="fixed" data-theme="b">
			<h4>Login</h4>
		</div>
	</div>
	</div>
</body>
</html>