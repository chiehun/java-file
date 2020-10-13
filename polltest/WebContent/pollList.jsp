<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<head>
<meta charset=UTF-8">
<title>투표 list</title>
</head>
<body>
	<h3>투표 프로그램</h3>
	<hr>
	<h4> 설문폼</h4>
	<table border="1" align ="center">
	<tr>
	
	<td><input type="text" size ="50" name="question"></td>
	</tr>
	<tr>
	<td align ="center" colspan="5" size="10">투표 </td>
	<td><input type="submit" value="결과" size="10"onclick="location.href='pollview.jsp'"/></td>
	</tr>
	</table>
	<hr>
	<table border="1" align ="center">
	<h4>설문 리스트 </h4>
	<tr>
	<td>번호</td>
	<td>제목</td>
	<td>시작일~종료일</td>
	<td><input type="submit" value="작성하기" size="10" onclick="javacript : location.href='pollInsert'.jsp"/></td>
	</tr>
		
	</table>
</body>
</html>