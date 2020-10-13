<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.util.* , com.hun.dto.GoodsDTO" %>
<% ArrayList<GoodsDTO> list = (ArrayList<GoodsDTO>)request.getAttribute("result");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록 화면 : goodlist.jsp</title>
<style>
	a: link, a: viestied a: action{
		text-decoration:none;
		color: black;		}
		
		tr : hover, tr : focus{
			background= color: orange;		
		}
		th{
		text-align: center;
		}
		td{
			border-bottom: 1px solid #e4e4e4;
			text-align: center;
		}		
	}	
</style>
</head>
<body>
	<h3> 상품 목록 화면</h3>
	<hr><!-- 가로 구분선 만드는 태그 -->
	
<table border="1">
	<tr>
		<th>상품 번호</th><th>상품 번호</th>
		<th>상품 가격</th><th>판매자</th>
	</tr>	
		
	<% for(GoodsDTO dto:list){	
			%>	
	<tr>
	<td><a href="GoodsDetailServlet?code=<%=dto.getCode()%>">
	   <% out.println(dto.getCode()); %>
	</a></td>
	<td><a href="GoodsDetailServlet?code=<%=dto.getCode()%>">
	   <%out.print(dto.getProduct()); %>
	</a></td>
	<td><a href="GoodsDetailServlet?code=<%=dto.getCode()%>">
	   <%out.print(dto.getPrice()); %>
	</a></td>
	<td><a href="GoodsDetailServlet?code=<%=dto.getCode()%>">
	   <%out.print(dto.getName()); %>
	</a></td>
	</tr>	
<% 		
}
	%>
	</table>		
</body>
</html>