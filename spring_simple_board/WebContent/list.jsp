<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.*, board.dto.*"%>

​

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>게시판 목록</title>

</head>

​

<body>

	<table border="1">

		<tr>

			<td align="center" colspan="5">*** 게시판 목록*** <a
				href="writeui.do">글쓰기</a>

			</td>

		</tr>
		<tr>

			<th>번호</th>

			<th>제목</th>

			<th>작성자</th>

			<th>작성일</th>

			<th>조회수</th>

		</tr>

		<%
			//목록 출력 부분
		%>

​

       <tr>

			<td align="center">번호 출력 부분</td>

			<td><a href="retrieve.do?num=번호">제목 출력 부분</a></td>

			<td>작성자 출력 부분</td>

			<td>작성일 출력 부분</td>

			<td>조회수 출력 부분</td>

		</tr>

		<%
			// }//end while

			// }//end if
		%>


		<!-- 검색 기능 시작 -->

		<tr>

			<td colspan="5" align="center">

				<form action="search.do">

					<select name="searchName" size="1">

						<option value="author">작성자</option>

						<option value="title">제목</option>

					</select> <input type="text" name="searchValue" /> <input type="submit"
						value="검색" />

				</form>

			</td>

		</tr>

</table>

</body>

</html>
