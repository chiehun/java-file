<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 등록 폼</title>
<script src="//cdn.ckeditor.com/4.11.4/standard/ckeditor.js"></script>
</head>

<body>
<h3>게시글 등록 화면</h3>
<hr>

	<form action=" boardWrite"  method="post" >
	
	<table border="1" summary="게시판 등록 폼">
		<caption>게시글 등록 폼</caption>
		
		<colgroup>
			<col width="100" />
			<col width="500" />
		</colgroup>
		
		<tbody>
		
			<tr>
				<th align="center">제목</th>
				<td><input type="text" name="subject" size="80" maxlength="100" required /></td>
			</tr>
			
			<tr>
				<th align="center">작성자</th>
				<td><input type="text" name="writer" maxlength="20" required /></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<textarea name="contents" id="editor1" cols="80" rows="10" >
					</textarea>
					<script>
						CKEDITOR.replace('editor1');
					</script>
				</td>
			</tr>
		</tbody>
	</table>
	<p>
		<input type="button" value="목록" onclick="location.href='boardList'" />
		<input type="submit" value="글쓰기" />
	</p>
	</form>
</body>
</html>



