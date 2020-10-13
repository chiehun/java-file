<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="submenu.jsp" %>
<article>
	<div> <!-- 상단 왼쪽에 자리배치 -->
		<input type="button" value="이전페이지" style="float: left;"
					onClick="location.href='login.jsp'">
		<br/>
		<br/>
		<br/>
	</div>
	
	<div> <!-- 왼쪽에 자리배치  id로 조회-->
		<table border="1" style="float: left;">
			<tr>
				<td>아이디 :</td>
				<td id="ID">${detail.id }</td>
			</tr>
			<tr>
				<td>이름 :</td>
				<td id="name">${detail.name }</td>
			</tr>
			<tr>
				<td>연락처 :</td>
				<td>${detail.phone }</td>
			</tr>
			<tr>
				<td>주소 :</td>
				<td>${detail.address }</td>
			</tr>
			<tr>
				<td>등록일자 :</td>
				<td>${detail.enroll }</td>
			</tr>
		</table>
	</div>

	<div> <!-- 오른쪽에 자리배치 다른 테이블로 해야 한다 -->
		<table border="1">
			<tr>
				<td>시술일자 </td>
				<td>시술내역 </td>

			</tr>
			
			<tr>
				<td>${sisul.rsv_date }</td> <!--변경 -> detail -> sisul 시술 데이터를 따로 받아와야 하기 때문에  id로 따로 해야 한다. -->
				<td>${sisul.p_type }</td>
			</tr>
		</table>
	</div>

	<div> <!-- 하단 왼쪽의 버튼들 -->
		<input type="button" value="고객정보 및 시술내역 수정"
					onClick="location.href=''">				
		<input type="button" value="고객정보 삭제"
					onClick="delete_check()">
	</div>
</article>
<%@ include file="footer.jsp" %>