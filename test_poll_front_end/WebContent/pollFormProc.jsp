<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="pMgr" class="com.freeflux.DBConnectionMgr" />
<%
	request.setCharacterEncoding("UTF-8");
	int num = Integer.parseInt(request.getParameter("num"));  //num 값
	String[] itemnum = request.getParameterValues("itemnum"); // 다중선택일 수도 있기 때문에 배열로 받아준다.
	boolean flag = pMgr.updatePoll(num, itemnum);  //num와 itemnum 값에 count 값을 변경 시켜주겠다!
	String msg = "투표가 등록되지 않습니다.";
	if (flag) {
		msg = "투표가 정상적으로 등록되었습니다.";
	}// 실패하고 성공하고 list로 간다. 
%>
<script>
   alert("<%=msg%>");
   location.href="pollList.jsp?num=<%=num%>"; 
</script>