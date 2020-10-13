<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.hun.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center">

		<form action="">
			<h1>Nonage</h1>
			<hr>

			<table>
				<tr align="right">
				<select>
				<option value="ALL">
				</select>
					<td><input type="button" value="검색"
						onclick="location.href='prodSearch'" /></td>
					<td><input type="button" value="전체보기"
						onclick="location.href='prodSearch'" /></td>
					<td><input type="button" value="상품등록"
						onclick="location.href='prodSearch'" /></td>
				</tr>
			</table>
			<table align="left">
				<tr>
					<th><h3>Admin Setting</h3></th>
				</tr>
				<hr>
				<tr>
					<th>상품 리스트</th>
				</tr>
				<tr>
					<th>주문 리스트</th>
				</tr>
				<tr>
					<th>회원 리스트</th>
				</tr>
				<tr>
					<th>Q&A 리스트</th>
				</tr>
			</table>
			<table border="1">
				<tr>
					<td>번호</td>

					<td>상품 명</td>

					<td>원 가</td>

					<td>판매 가</td>

					<td>등 록 일</td>

					<td>상품 수정</td>

					<td>상품 삭제</td>
					</tr>
					<c:forEach var="product" items="${productList}">
					<tr>
						<td>${product.pseq}</td>
						<td>${product.name}</td>
						<td>${product.price}원</td>
						<td>${product.content}</td>
						<td>${product.indate}</td>
						<td><a href="productUpdate.do?code=${product.pseq}">상품 수정</a></td>
						<td><a href="productDelete.do?code=${product.pseq}">상품 삭제</a></td>
						</tr>
						</c:forEach>
				
			</table>
			</tr>
			</table>
		</form>
	</div>

</body>
</html>