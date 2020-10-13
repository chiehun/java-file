<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import = "java.sql.ResultSet" %>
<!DOCTYPE >
<html>
<head>
<meta charset=UTF-8>
<title>전체 상품 목록 </title>
<style >
	a: link, a: viestied a: action{
	text-decoration: none;
	color: black;
	}
	
	tr : hover, tr : focus{
		background= color : blue;
	}
	th{
	text-align: center;
	}
	td{
		border-bottom: 1px solid #e4e4e4;
		text-align: center;
	}
</style>
</head>
<body>
	<h3> 상품 품목</h3>
	<hr>
	<table border= "1">
	<tr>
	<th>no</th><th>pro_info </th><th>price </th>
	</tr>
<%
	ResultSet rs = (ResultSet)request.getAttribute("result");
		while(rs.next()){
%>	
	<tr>
	<td>
	<a href = "storinfo?n<%=rs.getString("pro_info") %>"></a>
		<%= rs.getInt("no") %>
	</td>
	
	<td>
	<a href = "storinfo?n<%=rs.getString("pro_info") %>"></a> 
		<%= rs.getString("pro_info") %>
	</td>
	
	<td>
	<a href = "storinfo?n<%=rs.getString("pro_info") %>"></a> 
		<%= rs.getString("price") %>
	</td>
	<% 
	}
		%>
	</tr>	
	</table>
	</body>
</html>