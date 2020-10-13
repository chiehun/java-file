<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset=UTF-8>
<title>pollInsert.jsp</title>
</head>
<body>
<h3  align="center">설문 작성</h3>
<hr>

<table border="1" align ="center">
<tr>
<td>질문</td>

<td><input type="text" name="question"/></td>
</tr>
</talbe>
<p>
<tr>
<td>1 :<input type= "text" name="item"/></td>
<td>2 : <input type= "text" name="item"/><br></td>
</tr>

<tr>
<td>3 :<input type= "text" name="item"/></td>
<td>4 : <input type= "text" name="item"/><br></td>
</tr>

<tr>
<td>5 : <input type= "text" name="item"/></td>
<td>6 : <input type= "text" name="item"/><br></td>
</tr>

<tr>
<td>7 : <input type= "text" name="item"/></td>
<td>8 : <input type= "text" name="item"/><br></td>
</tr>

<tr>
<td>시작일</td>
<td><input type="date" name="sdateY"><input type="date" name="sdateM"><input type="date" name="sdateD"></td>
</tr>
<tr>
<td>종료일</td>
<td><input type="date" name="edateY"><input type="date" name="edateM"><input type="date" name="edateD"></td>
</tr>
<tr>
<td>복수투표</td>
<select>
<option>
<td><input type="bott" name="type" value="yes" ></td>
</tr>
</option>
</select>


<tr><td><input type= "submit" value="작성하기" action="pollInsertProc"/></td>
<td><input type= "submit" value="다시쓰기" action="pollInsertProc"/></td>
<td><input type= "submit" value="리스트" action="pollInsertProc"/></td></tr>
</table>
</body>
</html>