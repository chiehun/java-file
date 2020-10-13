<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">
nav#sub_menu { 	/* 서브메뉴 왼쪽으로 위치 */
	float: left;
	margin-right: 10px;
	font-family: "맑은 고딕";
}

nav#sub_menu ul li {
	list-style-type: none;
	margin-top: 10px;
}

nav#sub_menu a {
	text-decoration: none;
	color: #666;
	border-bottom: 1px dotted #999;
	display: block;
	width: 100px;
	height: 25px;
	padding: 5px;
}

nav#sub_menu a:hover {
	border-bottom: 1px solid black;
}

nav#sub_menu ul {
	margin-left: -20px;
}
</style>

<br />
<br />
<hr>
<nav id="sub_menu">
	<ul>
		<li><a href='HairshopServlet?command=cus_list'> 예약관리</a></li>
		<li><a href='HairshopServlet?command=reson_list'> 고객리스트</a></li>
		<li style="cursor:pointer;" onclick="open_win('HairshopServlet?command=cus_insert_form', 'customerEnroll')"><a>고객등록</a></li>
		<li><a href='HairshopServlet?command=reson_list'>시술등록</a></li>
	</ul>
</nav>
