<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.freeflux.*,java.util.*"%>

<jsp:useBean id="pMgr" class="com.freeflux.DBConnectionMgr"/>

<%
	// 투표할 각 항목에 관련되 코드 입력 위치 결과버튼은 클릭하면 나오는 
	int num = 0;
	
	if(!(request.getParameter("num")==null || request.getParameter("num").equals(""))){
	num= Integer.parseInt(request.getParameter("num"));
	}
	//PollListBean : 설문내용, 투표시작날짜, 투표종료날짜, 중복투표 허용여부, 설문활성화 여부
	PollListBean plBean = pMgr.getList(num);  //쿼리 실행 결과 : 선택한 설문 조회
	List<String> vlist = pMgr.getItem(num);	  // 쿼리 실행 결과 : 항목들 조회
	
	String question = plBean.getQuestion();   //설문내용
	int type = plBean.getTypes();			  //중복투표 허용여부 : checkbox /radio
	int active = plBean.getActive();		  //설문활성화여부 : 설문 가능 여부
%>

<link href="style.css" rel="stylesheet" type="text/css">
<form method="post" action="pollFormProc.jsp">
<table border="1" width="300">
	<tr>
		<td colspan="2">Q : 설문 주제 출력 </td>
		
	</tr>
	
	<tr>
		<td colspan="2">
			<%
				// 설문에 대한 각 항목들을 출력할 위치
				for(int i=0; i<vlist.size(); i++){
					String itemList = vlist.get(i);
					if(type==1){
						out.println("<input type=checkbox name='itemnum' value=''"+i+"'/>");
					}else{
						out.println("<input type=radio name='itemnum' value='"+i+"'/>");
					}
					out.println(itemList+"<br.>");
					}
				%>
		</td>
	</tr>
	
	<tr>
		<td>
			<%
				//서버로 전송하기 위한 submit 버튼
				if(active==1){
					out.println("<input type='submit' value='투표'>");
				}else{
					out.println("투표");
				}
			
			%>
		</td>
		<td>
			<input type="button" value="결과" 
					   onclick="javascript:window.open('pollView.jsp?num=설문지 번호', 'PollView','width=500, height=350')">
		</td>
	</tr>
</table>

<input type="hidden" name="num" value="설문지 번호">
</form>