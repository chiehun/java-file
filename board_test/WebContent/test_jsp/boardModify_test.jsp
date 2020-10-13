<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"></meta>
	<title>게시판 수정 폼</title>

	<style type="text/css">
		* {font-size: 9pt;}
		p {width: 600px; text-align: right;}
		table tbody tr th {background-color: gray;} 
	</style>
	
</head>
<body>

	<form action="boardModify" method="post" >
		<input type="hidden" name="no" value="글번호" />
		
		<table border="1" summary="게시판 수정 폼">
			<caption>게시판 수정 폼</caption>
			<colgroup>
				<col width="100" />
				<col width="500" />
			</colgroup>
			<tbody>
				<tr>
					<th align="center">제목</th>
					<td>
					<input type="text" name="subject" size="80" maxlength="100" value="글제목"  /></td>
				</tr>
				<tr>
					<th align="center">작성자</th>
					<td><input type="text" name="writer" maxlength="20" value="작성자" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea name="contents" cols="80" rows="10">글내용</textarea>
					</td>
				</tr>
			</tbody>
		</table>
		
		<p>
			<input type="button" value="글목록으로 가기" onclick="location.href='boardlist?no=글번호'" />
			<input type="submit" value="글수정하기" />
		</p>
	
	</form>
</body>
</html>