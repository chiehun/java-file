<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="submenu.jsp" %>
<article>
	<div>
		
		<form name="formm" method="post">
		<table id="default" style="margin-left : 240px; width: 800px;">
		<thead>
			<tr>
				<th>이름</th>
				<th>연락처</th>
				<th>시술일자</th>
				<th>시술내역</th>
			</tr>
		<thead>
<%-- 			<c:forEach var="list" items="${proList }"> --%>
		<tbody>
			<tr>
				<td>${list.name }</td>
				<td>${list.phone }</td>
				<td>${list.rsv_date }</td>
				<td>${list.p_type }</td>
				<td style="width:10px;"><input id="butt" type="button" value="시술완료"
				 onclick="location.href='HairshopServlet?command=cusres_end&id=${list.id}'"></td>
			</tr>
		</tbody>
<%-- 			</c:forEach> --%>
		</table>
		</form>
	</div>
</article>
<%@ include file="footer.jsp" %>