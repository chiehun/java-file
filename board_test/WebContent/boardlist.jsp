<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import= "java.util.* , com.hun.dto.BoardModel" %>
<% ArrayList<BoardModel> dto = (ArrayList<BoardModel>) request.getAttribute("result"); %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"></meta>
	<title>게시판 목록</title>

	<style type="text/css">
		* {font-size: 9pt;}
		p {width: 600px; text-align: right;}
		table thead tr th {background-color: gray;}
	</style>
</head>

<body>
	<table border="1" summary="게시판 목록">
		<caption>게시판 목록</caption>
		<colgroup>
			<col width="50" />
			<col width="300" />
			<col width="80" />
			<col width="100" />
			<col width="50" />
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>글 들 </th>
				<th>조회수 </th>
				</tr>
		</thead>

		<tbody>
			<tr>
				<td align="center" colspan="5">등록된 게시물이 없습니다.</td>
			</tr>
			
			<% for(BoardModel bm : dto){			
			%>
			<tr>
				<td align="center"><a href="boardView?no=<%=bm.getNo()%>" /></a>
				<% out.print(bm.getNo()); %></td>
				<td align="center">><a href="boardView?no=<%=bm.getNo() %>" /></a>
				<%out.print(bm.getSubject());%></td>
				<td align="center"><a href="boardView?no=<%=bm.getNo() %> "/></a>
				<%out.print(bm.getContents());%></td>
				<td align="center"><a href="boardView?no=<%=bm.getNo() %> "/></a>
				<%out.print(bm.getWriter());%></td>
				<td align="center"><a href="boardView?no= <%=bm.getNo() %>"/></a>
				<%out.print(bm.getHit());%></td>
			</tr>
			<%
			}
			%>
		</tbody>

		<tfoot>
			<tr>
				<td align="center" colspan="5">Copyright ⓒ freeflux Corp. All Rights Reserved</td>
			</tr>
		</tfoot>
	</table>
	
	<p>
		<input type="button" value="글쓰기"  onclick="location.href='boardWrite'" />
	</p>
</body>
</html>