<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forward_form2.jsp</title>
</head>
<body>

<form action="forwardFrom2.jsp" method= "post">
	이름 : <input type =text id= "name" name="name"><br /><br />
	당신의 혈액형은? <br />
	
	<input type = "radio" id = "A" name = "bloodType" value= "A" />
	<label for= "a">A형</label><br />
	
	<input type = "radio" id = "B" name = "bloodType" value= "B" />
	<label for= "b">B형</label><br />
	
	<input type = "radio" id = "O" name = "bloodType" value= "O" />
	<label for= "b">O형</label><br />
	
	<input type = "radio" id = "AB" name = "bloodType" value= "AB" />
	<label for= "b">B형</label><br />
	<br />
	<input type= "submit" value= "보내기" >
</form>

</body>
</html>