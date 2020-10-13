<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String id = request.getParameter("id");
    	String password = request.getParameter("password");
    //SQL : select id from table where id=? and pw=?로 테스트 해야한다. 
    //if(rs.next){
    	
    	if(id.equals(password)){
    		session.setAttribute("MEMBERID", id);
    	
    //세션 수명 정하기 thread 사용
    //web.xml문서에서  세션 시간 값을 지정해 줄 수 있다
    %>
    
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 성공</title>
</head>
<body>
로그인에 성공 했습니다
</body>
</html>
<%}else{// 로그인 실패시
	%>
<script>
alert("로그인에 실패하였습니다");
history.go(-1); // 이전 페이지로 이동하는 JavaScript
</script>	
	<%
}
	%>
}