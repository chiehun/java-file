<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.hun.dto.*" %>
<%
BoardDTO model=(BoardDTO)request.getAttribute("MODEL");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"></meta>
	<title>게시판 상세보기</title>
	
	<style>
		* {font-size: 9pt;}
		.btn_align {width: 600px; text-align: right;}
		table tbody tr th {background-color: gray;}
	</style>

</head>

<body>
<h3>게시글 상세보기 화면</h3>
<hr>

	<table border="1" summary="게시판 상세조회">
		<caption>게시글 상세보기</caption>
		<colgroup>
			<col width="100" />
			<col width="500" />
		</colgroup>
		<tbody>
			<tr>
				<th align="center">제목</th>
				<td><%= model.getSubject() %></td>
			</tr>
			<tr>
				<th align="center">작성자/조회수</th>
				<td><%= model.getWriter() %> / <%= model.getHit() %></td>
			</tr>

			<tr>
				<td colspan="2"><%= model.getContents() %></td>
			</tr>
		</tbody>
	</table>
	
	<p class="btn_align">
		<input type="button" value="글목록으로 가기" onclick="location.href='boardList'"/>
		<input type="button" value="글수정으로 가기" onclick="location.href='boardModify?no=<%= model.getNo() %>'" />
		<input type="button" value="삭제하기" onclick="location.href='boardDelete?no=<%= model.getNo() %>'" />
	</p>
	
</body>
</html>



