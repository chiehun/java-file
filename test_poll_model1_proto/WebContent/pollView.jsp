<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.freeflux.*,java.util.*"%>

<jsp:useBean id="pMgr" class="com.freeflux.DBConnectionMgr" />

<%
	// 투표 현황에 관련된 코드 추가할 위치   // 출력하는 화면
	request.setCharacterEncoding("UTF-8");

	int num =0 ;
	if(request.getParameter("num")!= null){
		num = Integer.parseInt(request.getParameter("num"));
	}
	
	int sum = pMgr.sumCount(num);	// 쿼리 실행 : 해당 설문 전체 투표자
	List<PollItemBean> vilst = pMgr.getView(num); //쿼리 실행 : 해당 설문 항목
	PollListBean plBean = pMgr.getList(num);  // 쿼리 실행 : 해당 설문 관련
	
	String question = plBean.getQuestion();
	Random r = new Random();	//각 항목에 대한 색상을 임의로 설정
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Poll</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="#FFFFCC">
	<div align="center">
		<table border="1" width="400">
			<tr>
				<td colspan="4"><b>Q : <%=question %></b></td>
<!-- 				<b>Q : 설문 주제 출력</b> -->				
				
			</tr>
			
			<tr>
				<td colspan="3">
					<b>총 투표자 : 인원 수 합 출력</b>
				</td>
				<td width="40">count<b>총 투표자 <%=num %></b></td>
			</tr>
			
			<%
			// 막대 그래프 출력하기 위한 for() 문 시작 위치
			for (int i=0; i< vilst.size(); i++){
				PollItemBean piBean = vilst.get(i);
				String[] item = piBean.getPoll_item(); //항목명 ex) 김태희
		
			
			int rgb = r.nextInt(255*255*255);  //임의의 색상 RGB 각각(0~255)
			String rgbt = Integer.toHexString(rgb);  // 16진수로 변환
			String hRGB = "#" + rgbt;  // 색상은 #16진수(R), 16진수(G) 16진수(B)
			
			int count = piBean.getPoll_count();  //각 항목의 투표수
			int ratio = (new Double(Math.ceil((double)count/sum * 100))).intValue();
			//ratio : <table>의 크기를 값에 따라 자동 변경
			//Double객체.intValue() <= double 값을 정수로 반환하는 메서드
			
			%>
			
			<tr>
				<td width="20" align="center"><%=i+1 %></td><%-- 항목번호 --%>
				<td width="120"><%=item[0]%></td>						<%-- 항목명 --%>
				<td>
						<table width="<%=ratio %>" height="15">
							<tr>
								<td bgcolor="<%=hRGB%>"></td>  			<%-- 투표수에 대한 그래프 --%>
							</tr>
						</table>
				</td>
				<td width="40"><%=count%></td>							<%-- 투표수 --%>
			</tr>
			
			<%}// for() END %>
		</table>
		
		<p />
		<a href="javascript:window.close()">닫기</a>		<%--현재 창을 닫는 javascript 함수 --%>
	</div>
</body>
</html>