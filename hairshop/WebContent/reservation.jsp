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

<!-- 제이쿼리 라이브러리 -->
<script src="http://code.jquery.com/jquery-1.7.min.js"></script>

<!-- 제이쿼리 ui css -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">

<!-- Time picker -->
<script type="text/javascript" src="jquery.timepicker.min.js"></script>
<link rel="stylesheet" href="jquery.timepicker.min.css">

<!-- Date picker(제이쿼리 ui) -->
 <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 
<!-- 스크립트 추가 내용 -->
<script type="text/javascript">
$(document).ready(function() {
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth() + 1; // 1~12가 아니라 0~11로 반환되므로 +1
	var day = date.getDate();
	var hours = date.getHours();
	var minutes = date.getMinutes();
	var today = year + "-" + month + "-" + day;
	console.log(today);
	/*-------------------date picker---------------------------------*/
	
	$.datepicker.setDefaults({
        dateFormat: 'yy-mm-dd',	
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],	//한글 캘린더 요일 표시 부분
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],	//한글 요일 표시 부분
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],	// 한글 요일 표시 부분
        showMonthAfterYear: true,	// true : 년 월  false : 월 년 순으로 보여줌
        yearSuffix: '년',	
//	        showButtonPanel: true,	// 오늘로 가는 버튼과 달력 닫기 버튼 보기 옵션
//	        closeText: '닫기', // 닫기 버튼 텍스트 변경
//	        currentText: '오늘', // 오늘 텍스트 변경
    });
	
	$('#rsv_date').datepicker({
		maxDate : '+1m',
		minDate : '0'	// 예약가능 날짜는 당일부터 한달뒤까지만
	});

	$('#rsv_date').datepicker("setDate", "today"); // 기본값 세팅

	/*-------------------time picker---------------------------------*/
	
	console.log("현재 시간 => " + hours + ":" + minutes);

	// hours
	if(hours >19 || hours <10){
		hours = 10;
		minutes = '00';
	} else {
		// minutes 30분 단위 반올림
		if(minutes == 0){
			minutes = '00';
		} else if(minutes < 30) {
			minutes = 30;
		} else if(minutes > 30){
			minutes = '00';
			if(hours != 10 || hours != 20){
				hours +=1;	
			}
		}
	} // hours, minutes 설정 완료
	

	  
	console.log("시작 예약가능 시간 => " + hours + ":" + minutes);
	
	// timepicker 설정
	$('#rsv_time').timepicker({
		minTime : hours +":"+ minutes,
		maxTime : '20:00', // 마지막 예약가능 시간
		timeFormat : 'h:i a',
		step : 30, // 30분 단위로 지정.
		dropdown : true, // 드롭다운 표시 여부
		useSelect : true, // select 형태로 사용 -> 사용자가 임의로 입력시간 조절불가
//			disableTimeRanges : [ [ '1pm', '2pm' ], [ '3pm', '4:01 pm' ] ] // 막아놓을 시간 설정

	});

});
</script>

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
			<div class="ui-body ui-body-a">
			<h3>예약</h3>
				<form action="HairshopServlet?cus_res_insert" method="post">
					
					<label><b>예약날짜 :</b></label>
					<input type="text" name="rsv_date" id="rev_date" />
					
					<label><b>예약시간 :</b></label>
					<input type="text" name="rsv_time" id="rev_time" />
					
					<label><b>시술종류 :</b></label>
					<select name="p_type">
						<option value="cut">커트</option>
						<option value="color">염색</option>
						<option value="perm">파마</option>
					</select>
					<br /><br />
					<input type="hidden" name="id" value="${param.id }">
					<input type="submit" value="예약등록">
				</form>
			</div>
		<div data-role="footer" data-position="fixed" data-theme="b">
			<h4>Reservation</h4>
		</div>
	</div>
	</div>
</body>
</html>