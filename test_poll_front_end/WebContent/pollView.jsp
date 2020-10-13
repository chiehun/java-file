<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.freeflux.*,java.util.*"%>
<jsp:useBean id="pMgr" class="com.freeflux.DBConnectionMgr" />
<%
	request.setCharacterEncoding("UTF-8");
	int num = 0;
	if (request.getParameter("num") != null) {
		num = Integer.parseInt(request.getParameter("num"));
	} //num 값은 제목을 눌렀을경우에서만 날라간다. but 그러나 설문지에서 바로 결과값을 확인 할 수도 있기때문에 
	int sum = pMgr.sumCount(num); //합을 구해주는 query
	List<PollItemBean> vlist = pMgr.getView(num);
	PollListBean plBean = pMgr.getList(num);
	String question = plBean.getQuestion();
	Random r = new Random();
%>
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
				<td colspan="4"><b>Q : <%=question%></b></td>
			</tr>
			
			<tr>
				<td colspan="3"><b>총 투표자 : <%=sum%>명</b></td>
				<td width="40">count</td>
			</tr>
			
			<%
				for (int i = 0; i < vlist.size(); i++) {
					PollItemBean piBean = vlist.get(i);
					String[] item = piBean.getItem();//아이템 ex)김태희
					int rgb = r.nextInt(255 * 255 * 255);
					String rgbt = Integer.toHexString(rgb);
					String hRGB = "#" + rgbt;
					int count = piBean.getCount();//투표수
					int ratio = (new Double(Math.ceil((double) count / sum * 100))).intValue();
					//각자 비율을 만들어 준다.
					//.intValue(); 막대기 그려주는 메서드
			%>
			
			<tr>
				<td width="20" align="center"><%=i+1%></td>
				<td width="120"><%=item[0]%></td>
				<td>
						<table width="<%=ratio%>" height="15">
							<tr>
								<td bgcolor="<%=hRGB%>"></td>
							</tr>
						</table>
				</td>
				<td width="40"><%=count%></td>
			</tr>
			
			<%} // for END %>
		</table>
		
		<p />
		<a href="javascript:window.close()">닫기</a>
	</div>
</body>
</html>