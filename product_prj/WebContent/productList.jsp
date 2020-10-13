<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.hun.product.*"%>
<jsp:useBean id="DBdao" class="com.hun.product.DBconnect" />
<!DOCTYPE >
<html>
<head>
<meta charset=UTF-8>
<title>productList.jsp</title>
</head>
<body>
	<h2 align="center">상품 등록 리스트</h2>
	<hr width="600">
	<table>
	<tr>
		<td>
			<h5 align="right">
			<a href=productInsert.jsp><b>상품등록</b></a>
			</h5>
			
			<table border="1">
				<tr>
					<td align="center"><b>번호</b></td>
					<td size=10><b>제목</b></td>
					<td size=10><b>가격</b></td>
					<td size=10><b>상품수정</b></td>
					<td size=10><b>상품 삭제</b></td>
				</tr>
				<tr>
					<%
						List<ProductDTO> dto = DBdao.productList();
						for (int i = 0; i < dto.size(); i++) {
							ProductDTO List = dto.get(i);
							int code = List.getCode();
							String name = List.getName();
							int price = List.getPrice();
							out.println("<tr><td align='center'>"+code+ "</td>");
							out.println("<td align='center'>"+name+"</td>");
							out.println("<td align='center'>"+price+"</td>");
							out.println("<td><a href='productUpdate.jsp?code="+code+"'>"+"상품수정"+"</td>");
							out.println("<td><a href='productDelete.jsp?code="+code+"'>"+"상품삭제"+" </td>");
						}
					%>
				</tr>
			</table>
	</tr>
	</table>
</body>
</html>