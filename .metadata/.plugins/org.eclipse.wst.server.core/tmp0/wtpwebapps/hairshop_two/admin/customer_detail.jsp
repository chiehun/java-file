<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="submenu.jsp" %>
<article>
	<div> 
		<input id= butt type="button" value="이전페이지" style="float: left; margin-left: 30px; margin-top: 20px"
					onClick="go_back()">
		<br/>
		<br/>
		<br/>
	</div>
	
	<div> 
		<table id = "detailLeft" style="float: left;">
			<tr>
				<th>아이디 :</th>
				<td id="idd">${detail.id }</td>
			</tr>
			<tr>
				<th>이름 :</th>
				<td id="name">${detail.name }</td>
			</tr>
			<tr>
				<th>연락처 :</th>
				<td>${detail.phoneNumber }</td>
			</tr>
			<tr>
				<th>주소 :</th>
				<td>${detail.address }</td>
			</tr>
			<tr>
				<th>등록일자 :</th>
				<td>${detail.enroll }</td>
			</tr>
		</table>
	</div>

	<div>
	<div> 
		<table id = "detailRight" >
		
			<tr>
				<th>시술일자 </th>
				<th>시술내역 </th>

			</tr>
			<c:forEach var="procedure" items="${procedureList }">			
			<tr>
				<td>${procedure.sisul_date}</td>
				<td>${procedure.sisul_type}</td>
			</tr>
			</c:forEach>
		</table>
	</div>

	<div>
		<br />
		<input id="butt" type="button" value="고객정보 및 시술내역 수정"
					onClick="location.href='HairshopServlet?command=cus_detail_update&id=${detail.id}'">				
		<input id="butt" type="button" value="고객정보 삭제"
					onClick="delete_check()">
	</div>
	</div>
</article>
<%@ include file="footer.jsp" %>