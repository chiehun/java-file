<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품 등록 - 관리자 페이지</h2>
	<hr width="600">
	<form action ="productInsertProc.jsp" method="get">
	<table border="1">
		<tr>
			<td>상품명</td>
			<td><input type="text" name="name" rows="10" cols="15" /></td>
		</tr>
		<tr>
			<td>가격</td>
			<td><input type="text" name="price" rows="10" cols="15"/></td>
		</tr>
		<tr>
			<td rows="10" cols="15">사진</td>
			<td rows="10" cols="15">파일</td>
		</tr>
		<tr>
			<td>설명</td>
			<td><textarea rows="10" cols="300" name="description">
			</textarea></td>
		</tr>
		<tr>
			<tb>
			<table>
			<td align="center"><input type="submit" value="등록" /></td>
			<td align="center"><input type="reset" value="다시 작성" /><td>
			<td align="center"><input type="button" value="목록" onclick="javascript:location.href='productList.jsp'"/><td>
			</table>
			</tb>
		</tr>
	</table>
</form>

</body>
</html>