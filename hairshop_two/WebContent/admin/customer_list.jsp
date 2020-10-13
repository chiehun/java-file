<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="submenu.jsp" %>
<article>
	<div id= 'search'>
		<form name="formm" method="post">
			<label>고객검색</label>
			<select name="searchType">
				<option value="name">성 명</option>
				<option value="phone">연락처</option>
			</select>
			<input type="text" name="searchText" size="15">
			<input id="butt" style="background:black;" type="submit" value="검색" onclick="go_search()">
		</form>
	</div> <!-- 검색창 -->
	<br /><br /><br />
	<div>
	<c:choose> 
		<c:when test="${cusList.size()==0}">
			<h3 style="text-align: center;"> 고객이 없어요... </h3>
		</c:when>
		
		<c:otherwise>
			<table id="default" >
			<thead>
				<tr> 
					<th>이름</th>
					<th>연락처</th>
					<th>주소</th>
					<th>등록일자</th>
					<th>최근시술일자</th>
					<th>최근시술</th>
				</tr>
			</thead>
			<c:forEach var="list" items="${cusList }">
			<tbody>
				<tr>
					<td><a href="HairshopServlet?command=cus_detail&id=${cusList.id}">${cusList.name }</a></td>
					<td>${list.phone}</td>
					<td>${list.address}</td>
					<td>${list.enroll}</td>
					<td>${list.res_date}</td>
					<td>${list.p_type}</td>
				</tr>
				</tbody>
			</c:forEach>
			
			</table>
		</c:otherwise>
	</c:choose>
	</div>
</article>
<%@ include file="footer.jsp" %>