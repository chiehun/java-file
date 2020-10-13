<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="submenu.jsp" %>
<article>
	<div id= 'search'>
		<form action="고객 조회 액션 클래스로  이동" method="post">
			<label>고객검색</label>
			<select name="searchType">
				<option value="name">성 명</option>
				<option value="phone">연락처</option>
			</select>
			<input type="text" name="searchText" size="15">
			<input type="submit" value="검색" name="customerSearch">
		</form>
	</div> <!-- 검색창 -->
	<br /><br /><br />
	<div>
	<c:choose>
		<c:when test="${cusList.size()==0}">
			<h3 style="text-align: center;"> 고객이 없는 망한 헤어샵 </h3>
		</c:when> <!-- 예약관리 페이지에 들어갈 값이 없을 경우 -->
		<c:otherwise>
			<table border="1">
				<tr> 
					<th>이름</th>
					<th>연락처</th>
					<th>주소</th>
					<th>등록일자</th>
					<th>최근시술일자</th>
					<th>최근시술내역</th>
				</tr>
			<c:forEach var="list" items="${cusList }">
				<tr>
					<td><a href="아이디 값으로 상세보기 조회해주세요 ${cusList.id}">${cusList.name }</a></td>
					<td>${list.phone}</td>
					<td>${list.address}</td>
					<td>${list.enroll}</td>
					<td>${list.res_date}</td>
					<td>${list.p_type}</td>
				</tr>
			</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	</div>
</article>
<%@ include file="footer.jsp" %>