<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="pMgr" class="com.freeflux.DBConnectionMgr" />
<%
	// 투표(설문조사)가 제대로 등록되었는 지 여부..
	boolean flag = false;
	String msg = "투표가 등록되지 않습니다.";
	if (flag) {
		msg = "투표가 정상적으로 등록되었습니다.";
	}
%>
<script>
   // 경고창을 이용하여 확인
   // pollList.jsp으로 이동
</script>