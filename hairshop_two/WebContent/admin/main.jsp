<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="submenu.jsp" %>
<style></style>
<article>
	<div id= 'search'>
		<form name="formm" method="post">
			<label>고객검색</label>
			<select name="searchType">
				<option value="name">성 명</option>
				<option value="phone">연락처</option>
			</select>
			<input type="text" name="searchText" size="15">
			<input id="butt" style="background:black;" type="submit" value="검색" onclick="go_search()" name="customerSearch">
		</form>
	</div> 
	<br /><br /><br />
	<div>
	<c:choose>
		<c:when test="${resList.size()==0}">
			<h3 style="text-align: center;"> 현재 예약이 없습니다.</h3>
		</c:when> 
		<c:otherwise>
			<table id="default">
				<thead>
				<tr> 
					<th>예약일</th>
					<th>예약시간</th>
					<th>시술명<th>
					<th>예약상태</th>
					<th>이름</th>
					<th>연락처</th>
					<th>최근시술일</th>
					<th>최근시술</th>
				</tr>
				</thead>
				
				<tbody>
				<c:forEach var="list" items="${resList}">
				<tr>
					<td>${list.rsv_date }</td>
					<td>${list.rsv_time }</td>
					<td>${list.p_type }</td>
					<c:choose>
						<c:when test="${list.rsv_status==0}">
							<td>미확정</td>
						</c:when>
						<c:otherwise>
							<td>확정</td>
						</c:otherwise>
					</c:choose>
					<td><a id="name" href="HairshopServlet?command=cus_detail&id=${list.id}">${list.name }</a></td>
					<td>${list.phoneNumber }</td>
					<td>${list.sisul_date }</td>
					<td>${list.sisul_type }
					<input type="hidden" id="name" value="${list.name }" >
					<input type="hidden" id="id" value="${list.id }"  ></td>
					
					<c:choose> 
						<c:when test="${list.rsv_status==0}">
							<td style="width:45px;"><input id="butt" type="button" value="확정" 
						onclick="location.href='HairshopServlet?command=cusres_update&id=${list.id}'"></td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>	
					<td style="width:70px;">
					<input id="idd" type="button" value="예약취소" name="cancel"
						onclick="location.href='HairshopServlet?command=cusres_delete&id=${list.id}'"></td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
		</div>

</article>
<%@ include file="footer.jsp" %>