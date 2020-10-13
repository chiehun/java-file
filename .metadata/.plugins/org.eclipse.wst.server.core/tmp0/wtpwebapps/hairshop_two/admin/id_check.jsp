<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복확인</title>
<script type="text/javascript" src="admin.js"></script>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
<div>
	<form method="post" name="formm" action="HairshopServlet?command=id_check_form">
		User ID<input type="text" name="id" value="">
		<input type="submit" value="검색"><br />
		<div>
			<c:if test="${message==1 }">
				<script type="text/javascript">
					opener.document.formm.id.value="";
				</script>
				${id }는 이미 사용중인 아이디입니다.
			</c:if>
			
			<c:if test="${message==-1 }">
				${id }는 사용 가능한 아이디입니다.
				<button onclick="idok()">사용</button>
			</c:if>
		</div>
	</form>
</div>
</body>
</html>