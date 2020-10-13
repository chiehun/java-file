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
		<c:when test="${resList.size()==0}">
			<h3 style="text-align: center;"> 현재 예약이 없습니다.</h3>
		</c:when>
		<c:otherwise>
			<table border="1">
				<tr> 
					<th>예약일</th>
					<th>예약시간</th>
					<th>예약상태</th>
					<th>이름</th>
					<th>연락처</th>
					<th>최근시술일자</th>
					<th>최근시술내역</th>
					<th></th>
					<th></th>
				</tr>
				
				<c:forEach var="list" items="${resList}">
				<tr>
						
					<td>${list.rsv_date }</td>
					<td>${list.rsv_time }</td>
					<c:if test="${list.rsv_status==0 }"><td>미확정</td></c:if>
               		<c:if test="${list.rsv_status==1 }"><td>확정</td></c:if>
					<td id="name"><a href="HairshopServlet?command=cus_detail&id=${list.id}">${list.name}</a></td>
					<td>${list.phoneNumber }</td>
					<td>${list.rsv_date }</td>
					<td>${list.p_type }</td>
					
					<c:choose>
						<c:when test="${list.rsv_status==1}">
							<td></td>
						</c:when>
						<c:otherwise>
							<td><input type="button" value="확정" 
						onclick="location.href='HairshopServlet?command=cusres_update&id=${list.id}'"></td>
						</c:otherwise>
					</c:choose>	<!-- 에약이 확정된 경우 버튼 안뜨도록 -->
					
					<td><input type="hidden" id="id" value="${list.id}"  >
					<input type="button" value="예약취소" name="cancel"
						onclick="location.href='HairshopServlet?command=cusres_delete&id=${list.id}'"></td> <!-- cancel_check는 js에서 이동할 페이지 지정해주세요 "cancel_check()"-->
				</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
		</div>

</article>
<%@ include file="footer.jsp" %>