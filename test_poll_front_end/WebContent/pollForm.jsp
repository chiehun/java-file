<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.freeflux.*,java.util.*"%>
<jsp:useBean id="pMgr" class="com.freeflux.DBConnectionMgr"/>
<%
	  int num = 0;

	  if(!(request.getParameter("num")==null || request.getParameter("num").equals(""))){
		 num = Integer.parseInt(request.getParameter("num"));
	  }
	
	  PollListBean plBean = pMgr.getList(num); //tblPollList 테이블 query 실행해주는 메서드 -> 한레코드 가지고 와야 한다. 
	  List<String> vlist = pMgr.getItem(num);  //tblPollItem 해당 값을 꺼내주는 메서드 -> 항목명들을 가지고 와야 하기 때문에 List로 받아야 한다.
 		// 아이템 항목명을 가지고 있다.
	  String question = plBean.getQuestion();
	  int type = plBean.getType();
	  int active = plBean.getActive();
%>
<link href="style.css" rel="stylesheet" type="text/css">
<form method="post" action="pollFormProc.jsp"> 
<table border="1" width="300">
	<tr>
		<td colspan="2">Q : <%=question%></td>
	</tr>
	
	<tr>
		<td colspan="2">
			<%
				for(int i=0; i<vlist.size(); i++){
					String itemList = vlist.get(i);
					if(type==1){ //중복 투표 여부
						out.println("<input type=checkbox name='itemnum' value='"+i+"'>");
					}else{
						out.println("<input type=radio name='itemnum' value='"+i+"'>");
					}
					out.println(itemList+"<br>"); // 체크 박스 옆에 글짜 찍어주기
				}	//for END
			%>
		</td>
	</tr>
	
	<tr>
		<td>
			<%
				if(active==1){
					out.println("<input type='hidden' name='num' value='"+num+"'>");
						out.println("<input type='submit' value='투표'>");
					}else{
						out.println("투표");
					}
			%>
		</td>
		<td>
			<input type="button" value="결과" 
					   onclick="javascript:window.open('pollView.jsp?num=<%=num%>', 'PollView','width=500, height=350')">
		</td>
	</tr>
</table>

<input type="hidden" name="num" value="<%=num%>">
</form>