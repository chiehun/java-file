<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<%@ include file="submenu.jsp" %>
<article>
	<div> <!-- 상단 왼쪽에 자리배치 -->
		<input id= butt type="button" value="이전페이지" style="float: left; margin-left: 30px; margin-top: 20px"
					onClick="go_back()">
		<br/>
		<br/>
		<br/>
	</div>
	
	<form name="formm"
			method="post">
	<div> <!-- 왼쪽에 자리배치 -->
		<table id = "detailLeft" style="float: left;">
			<tr>
				<th>아이디 :</th>
				<td>${detail.id }
				<input type="hidden" name="id" value="${detail.id }"></td>
			</tr>
			<tr>
				<th>이름 :</th>
				<td><input type="text" name="name" value="${detail.name }"></td>
			</tr>
			<tr>
				<th>연락처 :</th>
				<td><input type="text" name="phone" value="${detail.phoneNumber }"></td>
			</tr>
			<tr>
				<th>주소 :</th>
				<td><input type="text" name="address" value="${detail.address }"></td>
			</tr>
			<tr>
				<th>등록일자 :</th>
				<td>${detail.enroll }
				<input type="hidden" name="enroll" value="${detail.enroll }"></td>
			</tr>
		</table>
	</div>

	<div> <!-- 오른쪽에 자리배치 -->
		<table id = "detailRight" >
		
			<tr>
				<th>시술일자</th>
				<th>시술내역</th>
			</tr>
			<c:forEach var="procedure" items="${procedureList }">	
			<tr>
				<td>${procedure.sisul_date}
				<input type="hidden" name="p_enroll" value="${procedure.sisul_date }"></td>
				<td><input type="text" name="p_type" value="${procedure.sisul_type}"></td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div> 
		<br />
		<input style="margin-left: 645px" id="butt" type="submit" value="수정" onclick="go_detail_update()">				
	</div>
	</form>
</article>
<%@ include file="footer.jsp" %>