<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forward_form3.jsp</title>
</head>
<body>
<h2>포워딩될 페이지에 파리미터값 전달하기 예제</h2>
	<form action="forawdFrom3.jsp" method="post">
	
	이름 입력  : <input type="text" name="name" /><br>
	
	<br /> 색 선택 : <br />
	<input type = "radio" name= "color" valuse= "yellow" />노랑색<br />
	<input type = "radio" name= "color" valuse= "green" />초록색<br/>
	<input type = "radio" name= "color" valuse= "blue" />파랑색<br />
	<input type = "radio" name= "color" valuse= "red" />빨강색<br />
	<p>
	<input type="submit" value= "확인" />
	
	</form>

</body>
</html>