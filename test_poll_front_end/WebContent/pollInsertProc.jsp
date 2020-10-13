<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<jsp:useBean id="pMgr" class="com.freeflux.DBConnectionMgr" />

<jsp:useBean id="plBean" class="com.freeflux.PollListBean" />
<jsp:setProperty property="*" name="plBean" />

<jsp:useBean id="piBean" class="com.freeflux.PollItemBean" />
<jsp:setProperty property="*" name="piBean" />

<%
// String[] tt= request.getParameterValues("item");-- 태그 값이 날아오기 때문에 쓰임 알아 놓자

	String sdate="";
	sdate += request.getParameter("sdateY") + "-";
	sdate += request.getParameter("sdateM") + "-";
	sdate += request.getParameter("sdateD");
	
	String edate="";
	edate += request.getParameter("edateY") + "-";
	edate += request.getParameter("edateM") + "-";
	edate += request.getParameter("edateD");
	
	plBean.setSdate(sdate);
	plBean.setEdate(edate);
	
	
// 	String[] 
	
// 	boolean flagList=true;
	boolean flagList = pMgr.insertPoll(plBean, piBean);
	out.println("pMgr.insertPollList(plBean, piBean); END");

	
	String msg = "설문 추가에 실패 하였습니다.";
	String url = "pollInsert.jsp";
	
	if (flagList) {
		msg = "설문이 추가 되었습니다.";
		url = "pollList.jsp";
	}
%>
<script>
   alert("<%=msg%>");
   location.href="<%=url%>";
</script>