<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.hun.dto.*" %>
<%
	List<BoardModel> list=(ArrayList<BoardModel>)request.getAttribute("LIST");
%>
<%
	BoardModel searchModel = (BoardModel)request.getAttribute("MODEL");
	String pageNavigator=(String)request.getAttribute("PAGE_NAIGAITGER");

%>
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

<h3>게시판 목록 화면</h3>
	
			<form action= "BoardListServlet">
			<p>
         <select name="searchType" >
         	<option value = "ALL" selected>전체 검색</option>
        	<option value = "SUBJECT" selected >제목</option>
        	<option value = "WRITER" selected>작성자</option>
        	<option value = "CONTENTS" selected>내용</option>
        	</select>
        <input type = "text" name= "searchText"/>
        <input type="submit" value="검색"> 
        </p>       
   </form>    
        
<hr>
	<table border="1" summary="게시판 목록">
		<caption>게시판 목록</caption>
		<colgroup>
			<col width="50" />
			<col width="300" />
			<col width="80" />
			<!--  1줄 추가 -->
			<col width="70" />
			<col width="70" />
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<!--  1작성일 추가 -->
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		
		
		<tbody>	
			
			<% if(list.size()==0){ %>
			<tr>
				<td align="center" colspan="5">등록된 게시물이 없습니다.</td>
			</tr>
			 <% 
				}else{ 
				 
				
			for(BoardModel model : list){
			%>		
			<tr>
				<td align="center"><%= model.getNo() %></td>
				<td><a href="boardView?no=<%= model.getNo() %>"><%= model.getSubject() %></a></td>
				<td align="center"><%= model.getWriter() %></td>
				<!--  1작성일 추가 -->
				<td align="center"><%= model.getModdate().substring(0, 10) %></td>
				<td align="center"><%= model.getHit() %></td>
			</tr>
			<%
					}
				}
			%>
			
		</tbody>
			
		<tfoot>
			<tr>
				<td align="center" colspan="4"><%= pageNavigator %></td>
			</tr>
		</tfoot>
	</table>
	
	<p>
		<input type="button" value="글쓰기"  onclick="location.href='boardWrite'" />
	</p>
</body>
</html>






