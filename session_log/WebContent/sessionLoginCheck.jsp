<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String memberId = (String) session.getAttribute("MEMBERRID");
    boolean login = (memberId == null)?false : true;
    
    // 로그인 상태를 계속 유지하고 다른일을 하기 위해서 계속 사용
    // 장바구니 담고 나서 결제 버튼을 누르고 결제 버튼은 인
    %>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인여부 검사 : sessionLoginCheck.jsp</title>
</head>
<body>

	<%
	if(login){
	%>
		아이디 "<%=memberId %>"로 로그인 한 상태
	<%	
	} else {
	%>
		로그인하지 않은 상태
	<%	
	}
	%>
</body>
</html>