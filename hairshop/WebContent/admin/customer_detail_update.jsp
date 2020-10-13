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
	
	<form action="해당 고객 정보 및 시술내역 수정완료 처리 후 해당고객 상세정보로 다시 가주세요"
			method="post">
	<div> <!-- 왼쪽에 자리배치 -->
		<table border="1" style="float: left;">
			<tr>
				<td>아이디 :</td>
				<td>${detail.id }</td>
			</tr>
			<tr>
				<td>이름 :</td>
				<td><input type="text" name="name" value="${detail.name }"></td>
			</tr>
			<tr>
				<td>연락처 :</td>
				<td><input type="text" name="name" value="${detail.phone }"></td>
			</tr>
			<tr>
				<td>주소 :</td>
				<td><input type="text" name="name" value="${detail.address }"></td>
			</tr>
			<tr>
				<td>등록일자 :</td>
				<td>${detail.enroll }</td>
			</tr>
		</table>
	</div>

	<div> <!-- 오른쪽에 자리배치 -->
		<table border="1">
			<tr>
				<td>시술일자</td>
				<td>시술내역</td>

			</tr>
			
			<tr>
				<td>${detail.date }</td>
				<td><input type="text" name="name" value="${detail.p_type }"></td>
			</tr>
		</table>
	</div>

	<div> <!-- 하단 왼쪽의 버튼들 -->
		<input type="submit" value="수정" >				
	</div>
	</form>
</article>
<%@ include file="footer.jsp" %>