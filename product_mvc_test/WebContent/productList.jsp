<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title> 검색 리스트 </title>
<link rel="stylesheet" type="text/css" href="css/shopping.css"/>
</head>
<body>
<top>
<h1>Nonage</h1>
<hr width="1000">
</top>
<article>
<h2>상품 리스트</h2>
<form action="frm" method="post">
<table>
<tr>
<td width="642">상품명 <input type="text" name="key">
<input class="btn" type="button" name="btn_search" value="검색">
<input class="btn" type="button" name="btn_search" value="등록">
<input class="btn" type="button" name="btn_search" value="검색">
</td>


</tr>



</table>


</form>
</article>


</body>
</html>