<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Employee Update</title>
	<style>
		th{
			text-align: center;
		}
		td{
			text-align: center;
		}
		input{
			color:darkgrey;
		}
	</style>
</head>

<body>
<h3>Employee Update</h3>
<hr> 
<% 
	ResultSet rs= (ResultSet)request.getAttribute("result");
	rs.next();
%>

<form action="EMPServletUpdate" method="post"> <!-- <===  -->
	<input type="hidden" name="no" value=<%=rs.getInt("no") %> />
	<table border="0">
		<tr>
			<th>Division	</th><th>Required Input</th>
		</tr>
		<tr>
			<td>AGE		</td><td><input type="text" size="15" name="age" value=<%=rs.getInt("age") %> required="required" autofocus="autofocus" /></td>
		</tr>
		<tr>
			<td>NAME		</td><td><input type="text" size="15" name="name" value=<%=rs.getString("name") %> required="required" /></td>
		</tr>
		<tr>	
			<td>PHONE	</td><td><input type="text" size="15" name="phone" value=<%=rs.getString("phone") %> required="required" /></td>
		</tr>
		<tr>	
			<td>GENDER	</td><td><input type="text" size="15" name="gender" value=<%=rs.getString("gender") %> required="required" /></td>
		</tr>
		<tr>	
			<td>JOB		</td><td><input type="text" size="15" name="job" value=<%=rs.getString("job") %> required="required" /></td>
		</tr>
		<tr>	
			<td>PAY		</td><td><input type="text" size="15" name="pay" value=<%=rs.getInt("pay") %> required="required" /></td>
		</tr>
		<tr>	
			<td>CODE		</td><td><input type="text" size="15" name="code" value=<%=rs.getString("code") %> required="required" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="수정" /></td><td><input type="reset" value="취소" /></td>
		</tr>
	</table>		
</form>
</body>
</html>