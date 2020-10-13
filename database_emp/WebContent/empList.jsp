<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import ="java.sql.ResultSet" %>
<!DOCTYPE >
<html>
<head>
<meta charset=UTF-8">
<title>전체 사원 목록 조회</title>
<style>
	a: link, a: viestied a: action{
		text-decoration:none;
		color: black;
		}
		
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
	<h3> Employee LIist</h3>
	<hr><%-- 가로 구분선을 만들는 ㅐ채크 --%>
	<table border = "1">
	<tr>
	<th> NO</tH><th>AGE</tH>
	<th> Name</tH><th>PHON</tH>
	<th> GENDER</tH><th> NO</tH>
	<th> PAY</tH><th> NO</tH>
	</tr>

<%
	ResultSet rs = (ResultSet)request.getAttribute("result");

			while(rs.next()){
	%>
	<tr>
	<td>	
	<a href = "EMPServletUpdate?n=<%=rs.getInt("no")%>">
		<%= rs.getString("no") %>
	</a>		
	</td>
	
	<td>	
	<a href = "EMPServletUpdate?n=<%=rs.getInt("no") %>">
		<%= rs.getInt("age") %>
	</a>		
	</td>
		<td>	
	<a href = "EMPServletUpdate?n=<%=rs.getInt("no")%>">
		<%= rs.getString("name") %>
	</a>		
	</td>
	
	<td>	
	<a href = "EMPServletUpdate?n=<%=rs.getInt("no") %>">
		<%= rs.getString("phone") %>
	</a>		
	</td>
		<td>	
	<a href = "EMPServletUpdate?n=<%=rs.getInt("no")%>">
		<%= rs.getString("gender") %>
	</a>		
	</td>
	
	<td>	
	<a href = "EMPServletUpdate?n=<%=rs.getInt("no") %>">
		<%= rs.getString("job") %>
	</a>		
	</td>
	<td>	
	<a href = "EMPServletUpdate?n=<%=rs.getInt("no") %>">
		<%= rs.getString("pay") %>
	</a>		
	</td>
	<td>	
	<a href = "EMPServletUpdate?n=<%=rs.getInt("no") %>">
		<%= rs.getString("code") %>
	</a>		
	</td>	
<% 	
	}%>
		<tr/>
	</table>
</body>
</html>