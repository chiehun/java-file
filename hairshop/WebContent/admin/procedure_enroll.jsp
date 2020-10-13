<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="submenu.jsp" %>
<article>
	<div>
		<c:forEach var="list" items="${proList }">
		<table border="1">
			<tr>
				<th>이름</th>
				<th>연락처</th>
				<th>시술일자</th>
				<th>시술내역</th>
				<th></th>
			</tr>
			<tr>
				<td>${list.name }</td>
				<td>${list.phone }</td>
				<td>${list.res_date }</td>
				<td><input type="text" name="pType" value="${list.p_type }"></td>
				<td><input type="button" value="시술완료" 
				onclick="해당아이디 값으로 예약상태 이용완료 처리해주시고 시술내역에 추가해주세요"></td>
			</tr>
		</table>
		</c:forEach>
	</div>
</article>
<%@ include file="footer.jsp" %>